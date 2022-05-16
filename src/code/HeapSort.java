package code;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = (len/2) - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr,0, i);
        }

    }

    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        // adjust struct of head, keep nature of heap, parent node > child node
        for (int k = 2*i+1; k < len; k = k*2+1) {
            // find max node
            if ((k+1) < len && arr[k+1] > arr[k]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
