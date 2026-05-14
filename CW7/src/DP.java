import java.util.Arrays;
import java.util.Comparator;

public class DP {
    static void main(String[] args) {
        int[][] massiv =    {{1 , 2 , 3} ,
                            {2 , 3 ,4 },
                            {3 , 4 , 5}};
        System.out.println(maxSumOfTable(massiv));
        System.out.println(lenBetween(6 , new int[]{3, 4, 12, 6, 14, 13}));
    }
    //Task4
    public static int maxSumOfTable(int[][] massiv){
            if (massiv == null || massiv.length == 0 || massiv[0].length == 0) {
                return 0;
            }

            int n = massiv.length;
            int m = massiv[0].length;
            int[] dp = new int[m];

            dp[0] = massiv[0][0];
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j - 1] + massiv[0][j];
            }
            for (int i = 1; i < n; i++) {
                dp[0] += massiv[i][0];
                for (int j = 1; j < m; j++) {
                    dp[j] = massiv[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }

            return dp[m - 1];
    }
    public static int lenBetween(int n , int[] nails){
        Arrays.sort(nails);
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans += nails[1] - nails[0];
                flag = true;
            }
            else if (i == n - 2) {
                ans += nails[n-1] - nails[n-2];
                break;
            }
            else if (flag) {
                flag = false;
                continue;
            }
            else {
                if (nails[i + 1] - nails[i] <= nails[i] - nails[i-1]) {
                    flag = true;
                    ans += nails[i + 1] - nails[i];
                }
                else {
                    ans += nails[i] - nails[i-1];
                }
            }
        }
        return ans;
    }
}
