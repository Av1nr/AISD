public class ArrayStack{
    private int[] data;
    private int size;
    private static final int CAPACITY = 10;

    public ArrayStack() {
        data = new int[CAPACITY];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    public int remove() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[--size];
    }

    public int last() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}