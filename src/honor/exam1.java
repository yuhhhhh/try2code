package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]) - 1, range = Integer.parseInt(input[1]);
        if (start + range > data.length) {
            range = data.length - start;
        }
        while (range > 0) {
            int len = Math.min(20, range);
            for (int i = 0; i < len; i++) {
//                 if (start >= data.length) {
//                     break;
//                 }
                System.out.print(data[start++]);
                if (i != len - 1) {
                    System.out.print(";");
                } else {
                    System.out.println();
                }
            }
            range -= 20;
        }
    }
}