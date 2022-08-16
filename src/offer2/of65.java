package offer2;

import java.util.HashMap;
import java.util.Map;

public class of65 {
    public int minimumLengthEncoding(String[] words) {
        Trie cur = new Trie();
        Map<Trie, String> map = new HashMap<>();
        for (String word : words) {
            Trie tmp = cur;
            for (int i = word.length() - 1; i >= 0; i--) {
                tmp = tmp.addAndGet(word.charAt(i));
            }
            map.put(tmp, word);
        }
        int res = 0;
        for (Trie t : map.keySet()) {
            if (t.cnt == 0) {
                res += map.get(t).length() + 1;
            }
        }
        return res;
    }

    class Trie {
        Trie[] children;
        int cnt;

        public Trie(){
            children = new Trie[26];
            cnt = 0;
        }

        public Trie addAndGet(char c) {
            cnt++;
            if (children[c - 'a'] == null) {
                children[c -'a'] = new Trie();
            }
            return children[c - 'a'];
        }
    }
}
