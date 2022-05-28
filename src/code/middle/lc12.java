package code.middle;

public class lc12 {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value) {
                num -= value;
                sb.append(symbols[i]);
            }
            if (num == 0) break;
        }
        return sb.toString();
    }


}
