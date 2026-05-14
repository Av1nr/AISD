public class Fibonacci {
    static void main(String[] args) {
        System.out.println(fibonacci2(5));
        System.out.println(fibonacci1(143));
        System.out.println(fibonacciChars("Собака какала"));
    }
    public static long fibonacci2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n] % 10;
    }
    public static boolean fibonacci1(int a){
        if (a == 0) return false;
        if (a == 1) return true;
        int[] dp = new int[a + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= a; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if(a == dp[i]){
                return true;
            }
            else if(a < dp[i]){
                return false;
            }
        }
        return true;
    }
    //приходит строка из максимум 30т символов, составить слово из символов, номера которых совпадают с числами фибоначчи
    public static String fibonacciChars(String str) {
        if (str == null || str == "") {
            return "";
        }
        int n = str.length();
        String result = "";
        int fibPrev = 0; // F(0)
        int fibCurr = 1; // F(1)
        if (fibPrev < n) {
            result += "" + str.charAt(fibPrev);
        }

        if (fibCurr < n) {
            result += "" + str.charAt(fibCurr);
        }
        while (true) {
            int fibNext = fibPrev + fibCurr;
            if (fibNext >= n) {
                break;
            }
            result += "" + str.charAt(fibNext);
            fibPrev = fibCurr;
            fibCurr = fibNext;
        }

        return result;
    }
}
