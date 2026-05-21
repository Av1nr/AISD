import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2 {
    static void main(String[] args) {

    }
    public static List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();

        int[] dp = new int[n];
        int[] prev = new int[n];
        int[] compact = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        Arrays.fill(compact, 0);

        int maxLength = 1;
        int bestEnd = 0;
        int bestCompact = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int newLength = dp[j] + 1;
                    int newCompact = compact[j] + (i - j);

                    if (newLength > dp[i] || (newLength == dp[i] && newCompact < compact[i])) {
                        dp[i] = newLength;
                        compact[i] = newCompact;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLength || (dp[i] == maxLength && compact[i] < bestCompact)) {
                maxLength = dp[i];
                bestEnd = i;
                bestCompact = compact[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        int current = bestEnd;
        while (current != -1) {
            result.add(arr[current]);
            current = prev[current];
        }
        Collections.reverse(result);

        return result;
    }
}
