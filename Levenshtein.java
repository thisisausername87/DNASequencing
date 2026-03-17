public class Levenshtein implements SequenceScoringAlgorithm {

    @Override
    public String getName() {
        return "Levenshtein Distance Algorithm";
    }

    @Override
    public double score(String exampleSequence, String inputSequence) {
        int m = exampleSequence.length();
        int n = inputSequence.length();

        int[][] comparison = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            comparison[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            comparison[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (exampleSequence.charAt(i - 1) == inputSequence.charAt(j - 1)) ? 0 : 1;

                comparison[i][j] = Math.min(
                    Math.min(
                        comparison[i - 1][j] + 1,
                        comparison[i][j - 1] + 1
                    ),
                    comparison[i - 1][j - 1] + cost
                );
            }
        }

        return comparison[m][n];
    }

    @Override
    public boolean higherScoreIsBetter() {
        return false;
    }
}
