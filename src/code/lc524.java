package code;

public class lc524 {
    public static void main(String[] args) {
        String s = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        String d = "ettphsiunoglotjlccurlre";
        int sLen = s.length();
        int dLen = d.length();
        int index = 0;
        char a = d.charAt(index);
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == a && dLen > 0) {
                System.out.println(s.charAt(i) + " " + a);
                a = d.charAt(++index);

                dLen--;

            }
        }
        System.out.println(dLen == 0);
    }
}
