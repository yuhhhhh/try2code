package code;
import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] array = new int[] {3, 44, 38, 5, 57, 15, 36, 26, 27, 2, 46};
//        int[] array = new int[] {5, 2, 1};
        //quickSort(array, 0, array.length - 1);

//        mergeSort(array, 0, array.length);
//        insertionSort(array, array.length);
//        bubbleSort(array, array.length);
        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l + 1 >= r) return;
        int first = l, last = r, key = nums[first];
        while (first < last) {
            while (first < last && nums[last] >= key) {
                last--;
            }
            nums[first] = nums[last];
            while (first <last && nums[first] <= key) {
                first++;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quickSort(nums, l, first);
        quickSort(nums, first + 1, r);
    }

    public static void mergeSort(int[] nums, int l, int r) {
        int[] temp = new int[nums.length];
        if (l + 1 >= r) return;
        int mid = (l + r)/ 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid, r);
        int index = l, p = l, q = mid;

        while (p < mid || q < r) {
            if (q >= r || (p < mid && nums[p] < nums[q])) {
                temp[index++] = nums[p++];
            }
            else {
                temp[index++] = nums[q++];
            }
        }

        for (int i = l; i < r; i++) {
            nums[i] = temp[i];
        }

    }

    public static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[] {a, b};
    }

    public static void insertionSort(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j-1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
    }

    public static void bubbleSort (int[] nums, int n) {
        boolean swapped;
        for (int i = 1; i < n; i++) {
            swapped = false;
            for (int j = 1; j < n - i + 1; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void selectionSort(int[] nums, int n) {
        int mid;
        for (int i = 0; i < n-1; i++) {
            mid = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[mid]) {
                    mid = j;
                }
            }
            int temp = nums[mid];
            nums[mid] = nums[i];
            nums[i] = temp;
        }
    }
}
