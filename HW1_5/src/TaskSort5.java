import java.util.Comparator;

public class TaskSort5 {
    public static void main(String[] args) {
        String[] names = {"3", "30", "34", "5", "9"};

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Формируем две возможные комбинации
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // Сравниваем их.
                // Если order2 > order1, значит s2 должно идти первым (возвращаем > 0).
                // compareTo возвращает > 0, если вызывающий объект больше аргумента.
                // Нам нужно отсортировать по убыванию результата конкатенации.
                return order2.compareTo(order1);
            }
        };

        mergeSort(names, comparator, 0, names.length - 1);

        // Вывод результата
        String result = "";
        for (String name : names) {
            System.out.print(name + " ");
            result = result + name;
        }
        System.out.println();
        System.out.println("Итоговое число: " + result);
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