package zoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Map<String, Set<String>> userRecord = new HashMap<>();
        Map<String, Set<String>> gupiaoRecord = new HashMap<>();
        List<Set<String>> recommend = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String[] inputs = br.readLine().split(" ");
            String user = inputs[1];
            if (inputs[0].equals("1")) {
                Set<String> set = new HashSet<>();
                inputs = br.readLine().split(" ");
                set.addAll(Arrays.asList(inputs));
                if (recommend.size() == 0) {
                    Set<String> newSet = new HashSet<>(set);
                    for (String str : newSet) {
                        gupiaoRecord.put(str, newSet);
                    }
                    recommend.add(newSet);
                } else {
                    Set<String> newSet = new HashSet<>(set);
                    for (String str : set) {
                        if (gupiaoRecord.containsKey(str)) {
                            Set<String> set1 = gupiaoRecord.get(str);
                            newSet.addAll(set1);
                            recommend.remove(set1);
                        }
                        gupiaoRecord.put(str, newSet);
                    }
                    recommend.add(newSet);
                }
                userRecord.put(user, set);
            } else {
                if (!userRecord.containsKey(user)) {
                    System.out.println("error");
                } else {
                    Set<String> userSet = userRecord.get(user);
                    Set<String> allSet;
                    for (String str : userSet) {
                        if (gupiaoRecord.containsKey(str)) {
                            allSet = gupiaoRecord.get(str);
                            System.out.println(allSet.size() - userSet.size());
                            break;
                        }
                    }
                }
            }
        }
    }
}
