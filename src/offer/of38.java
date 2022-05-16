package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Solution {
    static List<String> rec;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        System.out.print("[");
        for (int i = 0; i < rec.size(); i++) {
            if (i < rec.size() - 1) System.out.print(rec.get(i) + ", ");
            else System.out.print(rec.get(i));
        }
        System.out.print("]");
    }

    public static void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }

    }
}

