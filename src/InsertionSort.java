/*
- the number of elements that is going to be sorted is increment by 1 every iteration ( from beginning)
- for every index: put that index element at the correct index at LHS
- steps is reduced if array is sorted
- no of swaps reduced compared to bubble sort
- stable
- works good for array that is partially sorted
- takes part in hybrid sorting algo (combining other sorting algo)
 */

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertion(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
