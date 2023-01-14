import java.util.Arrays;

/*
- time complexity : worst/best case - O(n2)
- most intuitive
- for small table
*/
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selection(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = findMax(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMax(int[] arr, int first, int last) {
        int maxIndex = first;

        for (int i = first; i <= last; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
