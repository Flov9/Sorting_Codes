/*
- aka sinking sort/exchange sort
- with every pass the nth largest element is at the nth pos from the end (coz already sorted at end)
- space complexity : O(1) - inplace sorting
- time complexity : best case - O(n) if array sorted / worst case - O(n2) if array sorted in opposite
 */
public class BubbleSort {
    public static void main(String[] args) {

    }

    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;

            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, arr[j], arr[j - 1]);
                    swapped = true;
                }
            }


            // if no swapping happens break the loop
            if (!swapped) {
                return;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
