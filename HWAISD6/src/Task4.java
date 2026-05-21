import java.util.HashMap;
import java.util.Map;

public class Task4 {
    static void main(String[] args) {

    }
    public static long countGeometricProgressions(int[] arr, int k) {
        int n = arr.length;
        if (n < 3) return 0;
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();
        for (int val : arr) {
            right.put((long)val, right.getOrDefault((long)val, 0L) + 1);
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            long current = arr[i];
            right.put(current, right.get(current) - 1);
            if (k != 0) {
                if (current % k == 0) {
                    long prev = current / k;
                    long next = current * k;
                    long leftCount = left.getOrDefault(prev, 0L);
                    long rightCount = right.getOrDefault(next, 0L);
                    count += leftCount * rightCount;
                }
            }
            left.put(current, left.getOrDefault(current, 0L) + 1);
        }
        return count;
    }
}
