package SortAndSearch;
/*
- time complexity : worst case - O(n) / best case - O(1)
 */

public class SequentialSearch {
    public static void main(String[] args) {

    }

    static int sequential(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        // if no target found
        return -1;
    }
}
