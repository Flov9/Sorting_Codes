package SortAndSearch;
/*
- procedure is build heap by insert -> delete root
- Time complexity : O(n log n) - depends on the height of tree
- can be reduced using heapify
    - starts from the last non-leaf node
    - work its way up by swapping values
    - Time complexity : O(n)
- stability?
 */

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6};
        heap(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    static void heap(int[] arr, int n) {
        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        // delete node
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0); // i - 1 coz of size of heap decrease by 1 every deletion, 1 coz of
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
