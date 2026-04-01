/*
@author Toren Kochman
@version 2026-03-31
*/
public class LongestCommonSubsequence implements SequenceScoringAlgorithm {

  /*
  Gets the name of the algorithm and returns it to the program
  */
  
  @Override
  public String getName() {
      return "Longest Common Subsequence";
  }

  /*
  Creates a two dimensional array which is then filled at each index with the number
  of characters in sequence that are matching between the two strings, and since this
  method allows for skipping characters, it can more easily determins how much of each
  string must actually be changed to match both of them over a continuous substring
  */
  
  @Override
  public double score(String databaseSequence, String querySequence) {
      int m = databaseSequence.length();
      int n = querySequence.length();

      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (databaseSequence.charAt(i - 1) == querySequence.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
              }
          }
      }

      return dp[m][n];
  }

  /*
  Returns the highest score of the longest supersequence between the strings
  */
  
  @Override
  public boolean higherScoreIsBetter() {
      return true;
  }
}
