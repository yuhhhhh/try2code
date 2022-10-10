package gaotu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Arrays.sort(input, (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));
        int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
        if ((a + b) > c && (c - a) < b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
