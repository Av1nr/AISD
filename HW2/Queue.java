public class Queue<Integer> {
    private Node<Integer> head;//первый
    private Node<Integer> tail;//последний
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }
    public Integer firstOut(){
        return head.data;
    }
    public void getInfoAboutQueue(){
        for(int i = 0 ; i < size ; i++){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public void add(Integer item) {
        Node<Integer> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public Integer remove() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Очередь пуста");
        }
        Integer data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
}
