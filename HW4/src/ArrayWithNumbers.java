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
        enter.close();
        if(!have0(array)){
            System.out.println("Missing number is 0");
        }
        else{
            System.out.print("Missing number is: ");
            //Искал как сделать sum без использования переменных и вспомнил , что начали stream и lambda function
            System.out.println((l)*(l+1)/2 - Arrays.stream(array).sum());
        }
    }
    static boolean have0(int[] array){
        for (int element : array) {
            if (element == 0) {
                return true;
            }
        }
        return false;
    }
}
