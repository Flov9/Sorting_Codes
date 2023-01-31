package DataStructures;

public class Stack {
    private Object[] data;
    private int size = 0;

    public Stack() {
        this.data = new Object[10];
    }

    public Stack(int size) {
        this.data = new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object element) {
        if (size == data.length) {
            resize();
        }

        data[size] = element;

        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        size--;

        Object temp = data[size];
        data[size] = null;

        return temp;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return data[size - 1];
    }

    public void resize() {
        Object[] tempArray = data;

        data = new Object[tempArray.length * 2];
        System.arraycopy(tempArray, 0, data, 0, size);
    }
}
