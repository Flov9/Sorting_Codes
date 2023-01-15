/*
- implements a gap value
- decrement the gap value by every pass
- time complexity : depends on gap sequence but in this case will be O(n2)
 */

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        shell(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void shell(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap >= 1; gap /= 2) {
            for (int j = gap; j < n; j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (arr[i + gap] > arr[i]) {
                        break;
                    }
                    else {
                        swap(arr, i + gap, i);
                    }
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
