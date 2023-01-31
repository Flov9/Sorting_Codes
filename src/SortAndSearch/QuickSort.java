package SortAndSearch;
/*
- using a pivot
    - how to pick: random, corner, middle
- T(n) = T(k) + T(n - k - 1) + O(n)
- worst case: when the pivot picked is the biggest and already at the end of the array
    - T(n) = T(0) - T(n - 1) + O(n) = O(n2)
- best case: when the pivot picked is the middle
    - T(n) = T(n/2) - T(n/2) + O(n) = O(n log n)
- not stable
- in-place
- merge sort is better in linked list because unlike array, LL is not continuous memory allocation

 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quicksort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    // if use middle as the pivot
    static void quick(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2; // == (s + e) / 2
        int pivot = arr[mid];

        while (start <= end) {
            // these 2 while loops are to navigate the start and end pointers to the element index that have violations
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }

            // once the 2 pointers are set in stone, swap (only if start <= end)
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        quick(arr, low, end);
        quick(arr, start, high);
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // if use first as the pivot
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (start < end) {
            while (start <= high && arr[start] <= pivot) {
                start++;
            }
            while (end >= low && arr[end] > pivot) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
            }
        }

        // to swap the pivot to the correct place and form partitions
        swap(arr, low, end);
        return end;
    }

    // use with partition
    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int loc = partition(arr, low, high);
            quicksort(arr, low, loc - 1);
            quicksort(arr, loc + 1, high);
        }
    }
}
