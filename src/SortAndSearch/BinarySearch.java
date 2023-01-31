package SortAndSearch;
/*
- good if the array is sorted and the array.length is big
- time complexity : worst case - O(log n) / best case - O(1)
 */

public class BinarySearch {
    public static void main(String[] args) {

    }

    static int binary(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            if (target == arr[mid]) {
                return mid;
            }
            else if (target < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
