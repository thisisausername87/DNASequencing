/*
@author Toren Kochman
@version 2026-03-16
*/
public class Levenshtein implements SequenceScoringAlgorithm {

    /*
    gets the agorithm name and returns it to the program
    */

    @Override
    public String getName() {
        return "Levenshtein Distance Algorithm";
    }

    /*
    finds the length of both the original and comparison DNA sequences
    and creates a 2 dimensional array in which weights for each option
    are calculated
    base cases of empty strings are considered and put into the array
    with their own weights
    */

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

        /*
        a nested loop is used to compare the options for each change
        made to the DNA sequences including insertion, deletion, and
        replacement which are then given weights based on previous
        indexes and weights
        inbuild java methods grab characters from the DNA strings and
        compare them for each index in the array to calculate the
        minimum possible cost to covert any one DNA string into another
        */

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

        /*
        returns the final calculated cost to get the strings to be the
        same as one another using the minimum possible costs at each step
        */

        return comparison[m][n];
    }

    /*
    returns the boolean object of higherScoreIsBetter as false since in this
    algorithm having a higher cost is a worse final outcome
    ensuring that the lowest cost and therefore the lowest possible score is
    considered the best outcome allows for the best functioning algorithm
    */

    @Override
    public boolean higherScoreIsBetter() {
        return false;
    }
}
