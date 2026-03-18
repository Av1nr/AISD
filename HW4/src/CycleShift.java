import java.util.Scanner;

class CycleShift {
    static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.print("Введите стартовое слово: ");
        String start = enter.nextLine();
        System.out.print("Введите слово , которое проверяется на циклический сдвиг: ");
        String get = enter.nextLine();
        enter.close();
        if(start.equals(get)){
            System.out.println("They are the same");
        }
        else if(start.length() != get.length()){
            System.out.println("They have different length");
        }
        else if((start + start).contains(get)){
            System.out.println("Cycle Shift");
        }
        else{
            System.out.println("They are not the same and  there is no cycle shift");
        }
    }
}
