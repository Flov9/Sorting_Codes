/*
- time complexity : worst case - O(1) / best case - O(n)
 */

public class SequentialSearch {
    public static void main(String[] args) {

    }

    static int sequential(int[] arr, int target) {
        int n = arr.length;

        if (n == 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        // if no target found
        return -1;
    }
}
