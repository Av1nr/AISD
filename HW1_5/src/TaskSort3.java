import java.util.Comparator;

public class TaskSort3 {
    public static void main(String[] args) {
        String[] names = {"apple", "banana", "kiwi", "cherry", "date", "fig", "grape"};
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int lenCompare = Integer.compare(s1.length(), s2.length());
                if (lenCompare != 0) return lenCompare;
                return s1.compareTo(s2);
            }
        };

        mergeSort(names, comparator, 0, names.length - 1);
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
    private static void mergeSort(String[] arr, Comparator<String> comp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, comp, left, mid);
            mergeSort(arr, comp, mid + 1, right);
            merge(arr, comp, left, mid, right);
        }
    }
    private static void merge(String[] arr, Comparator<String> comp, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (comp.compare(leftArr[i], rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}