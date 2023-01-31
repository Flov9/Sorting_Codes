package DataStructures;

public class BST {
    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    private Node insertNode(Node current, int value) {
        if (isEmpty()) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertNode(current.left, value);
        }
        else if (value > current.value) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    private Node deleteNode(Node current, int value) {
        if (isEmpty()) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteNode(current.left, value);
            return current;
        }
        else if (value > current.value) {
            current.right = deleteNode(current.right, value);
            return current;
        }
        /*
        3 cases: node has no children/node has one children/node has two children
         */
        else {
            if (current.left == null && current.right == null) { // case 1
                return null;
            }
            if (current.right == null) { // case 2
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? containsNode(current.left, value) : containsNode(current.right, value);
    }
}
