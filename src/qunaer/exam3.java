package qunaer;

import java.util.*;

public class exam3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 翻牌
     *
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    Map<String, Integer> transMap = new HashMap<>();

    public String showDown(String inHand) {
        // write code here
        String[] cards = inHand.split(" ");
        if (cards.length < 5) return "GaoPai";
        transMap.put("A", 1);
        transMap.put("2", 2);
        transMap.put("3", 3);
        transMap.put("4", 4);
        transMap.put("5", 5);
        transMap.put("6", 6);
        transMap.put("7", 7);
        transMap.put("8", 8);
        transMap.put("9", 9);
        transMap.put("10", 10);
        transMap.put("J", 11);
        transMap.put("Q", 12);
        transMap.put("K", 13);
        Map<Integer, String> resMap = new HashMap<>();
        resMap.put(1, "HuangJiaTongHuaShun");
        resMap.put(2, "TongHuaShun");
        resMap.put(3, "SiTiao");
        resMap.put(4, "HuLU");
        resMap.put(5, "TongHua");
        resMap.put(6, "ShunZi");
        resMap.put(7, "SanTiao");
        resMap.put(8, "LiangDui");
        resMap.put(9, "YiDui");
        resMap.put(10, "GaoPai");
        Map<String, Set<String>> huaMap = new HashMap<>();
        Map<String, Integer> numMap = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            String hua = cards[i].substring(0, 1), num = cards[i].substring(1);
            Set<String> set = huaMap.getOrDefault(hua, new HashSet<>());
            set.add(num);
            huaMap.put(hua, set);
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        int res = 10;
        int cnt3 = 0, cnt2 = 0, cnt4 = 0;
        for (String num : numMap.keySet()) {
            int cnt = numMap.get(num);
            if (cnt == 2) {
                cnt2++;
            } else if (cnt == 3) {
                cnt3++;
            } else if (cnt == 4) {
                cnt4++;
            }
        }
        if (cnt2 > 0) {
            if (cnt2 > 1) res = 8;
            else res = 9;
        }
        if (cnt3 > 0) {
            if (cnt2 > 0) res = 4;
            else res = 7;
        }
        if (cnt4 > 0) res = 3;
        for (String hua : huaMap.keySet()) {
            if (huaMap.get(hua).size() >= 5) {
                res = Math.min(res, 5);
                Set<String> set = huaMap.get(hua);
                int n = findShunZi(set);
                if (n == 1) res = 1;
                else if (n > 0) res = 2;
            }
        }
        if (res > 6) {
            int n = findShunZi(numMap.keySet());
            if (n > 0) res = 6;
        }
        return resMap.get(res);
    }

    public int findShunZi(Set<String> set) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String str : set) {
            list.add(transMap.get(str));
        }
        list.sort((n1, n2) -> n1 - n2);
        for (int i = 0; i < list.size() - 4; i++) {
            if (list.get(i) + 4 == list.get(i + 4)) return i + 4;
        }
        if (list.size() >= 5 && list.get(0) == 1 && list.get(list.size() - 4) == 10) return 1;
        return 0;
    }
}
