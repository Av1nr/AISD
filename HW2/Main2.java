public class Main2 {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        Queue<Integer> queueFinal = new Queue<>();

        queue1.add(1);
        queue1.add(2);
        queue1.add(5);
        queue2.add(2);
        queue2.add(3);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                queueFinal.add(queue2.remove());
            } else if (queue2.isEmpty()) {
                queueFinal.add(queue1.remove());
            } else {
                if (queue1.firstOut() < queue2.firstOut()) {
                    queueFinal.add(queue1.remove());
                } else {
                    queueFinal.add(queue2.remove());
                }
            }
        }
        queueFinal.getInfoAboutQueue();
    }
}