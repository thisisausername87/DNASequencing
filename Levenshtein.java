public class Levenshtein implements SequenceScoringAlgorithm {

    @Override
    public String getName() {
        return "Levenshtein Distance Algorithm";
    }

    @Override
    public double score(String exampleSequence, String inputSequence) {
        int m = exampleSequence.length();
        int n = input=Sequence.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (databaseSequence.charAt(i - 1) == querySequence.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                    Math.min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                    ),
                    dp[i - 1][j - 1] + cost
                );
            }
        }

        return dp[m][n];
    }

    @Override
    public boolean higherScoreIsBetter() {
        return false;
    }
}
