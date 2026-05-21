import java.util.HashSet;
import java.util.Set;

public class Task1 {
    static void main(String[] args) {

    }
    public static int countDifferentSums(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer>[][] dp = new Set[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashSet<>();

                if (i == 0 && j == 0) {
                    dp[i][j].add(grid[i][j]);
                } else {
                    if (i > 0) {
                        for (int sum : dp[i-1][j]) {
                            dp[i][j].add(sum + grid[i][j]);
                        }
                    }
                    if (j > 0) {
                        for (int sum : dp[i][j-1]) {
                            dp[i][j].add(sum + grid[i][j]);
                        }
                    }
                }
            }
        }

        return dp[n-1][m-1].size();
    }
}
