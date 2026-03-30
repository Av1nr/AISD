import java.util.HashMap;

public class Task1 {
    static void main(String[] args) {
        int[] arr = {1 , 2, 3, 4 ,5 ,6};
        int target = 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //Дополнение делаем
            int complement = target - arr[i];
            //Например, когда мы дойдем до 4, мы получим, что наш complement = 3, а 3 у нас уже есть в мапе
            if (map.containsKey(complement)) {
                System.out.println(arr[map.get(complement)] + ", " + arr[i]);
            }
            //Для нашего массива добавляем просто в нашу мапу все значения по факту
            map.put(arr[i], i);
        }
    }
}
