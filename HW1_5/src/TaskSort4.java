public class TaskSort4 {
    static void main(String[] args) {
        int[] x = {1 ,2 ,3 , 4 , 5 ,6 ,7 , 7};
        int l = 0;
        int r = x.length - 1;
        int target = 7;
        while(l < r){
            if(x[l] + x[r] > target){
                r--;
            }
            else if(x[r] + x[l] < target){
                l++;
            }
            else{
                System.out.println("" + x[r] + x[l]);
                break;
            }
        }
    }
}
