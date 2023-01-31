package DataStructures;

public class LinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> first, last;
    private int size;

    public void display() {
        Node<E> current = first;

        while (current != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }

        System.out.print("null\tsize:" + size);
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>(element);
        node.next = first;
        first = node;

        size++;

        if (last == null) { // if last not pointing to anything = first item in LL
            last = first;
        }
    }

    public void addLast(E element) {
        Node<E> node = new Node<>(element);

        if (last == null) {
            first = last = node;
        }
        else {
            node.next = null;
            last.next = node;
            last = node;
        }

        size++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        }
        else if (index == size) {
            addLast(element);
        }
        else {
            Node<E> current = first;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            Node<E> node = new Node<>(element);
            node.next = current.next;
            current.next = node;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Node<E> temp = first;
            first = first.next;

            size--;

            if (first == null) {
                last = null;
            }

            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else {
            Node<E> current = first;

            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }

            Node<E> temp = last;
            current.next = null;
            last = current;

            size--;

            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0){
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> current = first;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            Node<E> temp = current.next;
            current.next = current.next.next;

            size--;

            return temp.element;
        }
    }

    public E get(int index) {
        Node<E> current = first;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        return current.next.element;
    }

    public boolean contains(E element) {
        Node<E> current = first;

        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
