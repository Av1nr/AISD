public class EuclidsAlgorithm{
    public static void main(String[] args) {
        System.out.println(ourmethod(4 , 120));
        System.out.println(ourmethod2(4 , 120));
    }
    //Рекурсией
    public static int ourmethod(int a , int b){
        if(b == 0){
            return a;
        }
        else{
            return ourmethod(b , a % b);
        }
    }
    //просто циклом
    public static int ourmethod2(int a , int b){
        while(b != 0){
            int zapomni = b;
            b = a % b;
            a = zapomni;
        }
        return a;
    }
}