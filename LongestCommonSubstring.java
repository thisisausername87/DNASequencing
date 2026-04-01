/*
@author Toren Kochman
@version 2026-03-31
*/
public class LongestCommonSubstring implements SequenceScoringAlgorithm {

  /*
  Gets the name of the algorithm and returns it to the program
  */

  @Override
  public String getName() {
      return "Longest Common Substring";
  }

  /*
  Creates a two dimensional array which then is filled with lengths of the longest
  continuous substring at each possible step. This shows the longest possible 
  substring existing at any given index of the array and returns the highest score
  */

  @Override
   public double score(String databaseSequence, String querySequence) {
      int m = databaseSequence.length();
      int n = querySequence.length();

      int[][] dp = new int[m + 1][n + 1];
      int maxLength = 0;

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (databaseSequence.charAt(i - 1) == querySequence.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
                  maxLength = Math.max(maxLength, dp[i][j]);
              } else {
                  dp[i][j] = 0;
              }
          }
      }

      return maxLength;
  }

  @Override
  public boolean higherScoreIsBetter() {
      return true;
  }
}
