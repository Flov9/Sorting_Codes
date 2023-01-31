package DataStructures;

public class Queue {
    private Object[] queue;
    private int frontIndex;
    private int backIndex;
    private int size;

    public Queue(int size) {
        queue = new Object[size];
        frontIndex = 0;
        backIndex = size - 1;
        this.size = 0;
    }

    public void enqueue(Object obj) {
        if (isFull()) {
            increaseCap();
        }

        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = obj;

        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Object temp = queue[frontIndex];
        frontIndex = (frontIndex + 1) % queue.length;

        size--;

        return temp;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void increaseCap() {
        Object[] oldQ = queue;

        queue = new Object[2 * oldQ.length];

        for (int i = 0; i < oldQ.length; i++) {
            queue[i] = oldQ[frontIndex];
            frontIndex = (frontIndex + 1) % oldQ.length;
        }

        frontIndex = 0;
        backIndex = oldQ.length - 1;
    }


}
