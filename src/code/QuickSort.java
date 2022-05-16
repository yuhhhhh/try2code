package code;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        int len = r - l + 1;
        if (len == 1 || len == 0) return ;
        int i = l, j = r;
        int key = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= key) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        quickSort(arr, l, i);
        quickSort(arr, i+1, r);
    }
}
