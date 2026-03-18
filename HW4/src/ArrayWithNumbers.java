import java.util.Arrays;
import java.util.Scanner;

class ArrayWithNumbers {
    static void main(String args[]) {
        Scanner enter = new Scanner(System.in);
        System.out.print("Длина массива: ");
        int l = enter.nextInt();
        int[] array = new int[l];
        for(int i = 0 ; i < l; i++){
            System.out.print("Введите элемент на [" + i + "] месте: ");
            array[i] = enter.nextInt();
        }
        System.out.print("Missing number is: ");
        //Искал как сделать sum без использования переменных и вспомнил , что начали stream и lambda function
        System.out.println((l)*(l+1)/2 - Arrays.stream(array).sum());
    }
}
