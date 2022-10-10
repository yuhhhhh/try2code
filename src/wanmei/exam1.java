package wanmei;

import java.util.*;

public class exam1 {

    public static class Item {
        public final String name;
        public int num;

        public Item(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString() {
            return "[" + name + "," + num + "]";
        }
    }

    public List<Item> tryAddAndPack(List<Item> itemList, List<Item> itemAddList, Map<String, Integer> confMap, int capacity) {
        //TODO
        HashMap<String, Integer> map = new HashMap<>();
        for (Item i : itemList) {
            map.put(i.name, map.getOrDefault(i.name, 0) + i.num);
        }
        List<Item> newList = new ArrayList<>();
        for (String name : map.keySet()) {
            int cnt = map.get(name);
            while (cnt > 0) {
                Item tmp;
                if (cnt > confMap.get(name)) {
                    tmp = new Item(name, confMap.get(name));
                    cnt -= confMap.get(name);
                } else {
                    tmp = new Item(name, cnt);
                    cnt = 0;
                }
                newList.add(tmp);
            }
        }
        for (Item i : itemAddList) {
            map.put(i.name, map.getOrDefault(i.name, 0) + i.num);
        }
        int expectCap = 0;
        for (String name : map.keySet()) {
            expectCap += map.get(name) / confMap.get(name);
            expectCap += map.get(name) % confMap.get(name) == 0 ? 0 : 1;
        }
        newList.clear();
        if (expectCap <= capacity) {
            for (String name : map.keySet()) {
                int cnt = map.get(name);
                while (cnt > 0) {
                    Item tmp;
                    if (cnt > confMap.get(name)) {
                        tmp = new Item(name, confMap.get(name));
                        cnt -= confMap.get(name);
                    } else {
                        tmp = new Item(name, cnt);
                        cnt = 0;
                    }
                    newList.add(tmp);
                }
            }
        }
        newList.sort((i1, i2)->{
            if (i1.num == confMap.get(i1.name) && i2.num == confMap.get(i2.name)) {
                return i1.name.compareTo(i2.name);
            } else if (i1.num == confMap.get(i1.name)) {
                return 0;
            } else if (i2.num == confMap.get(i2.name)) {
                return 1;
            } else {
                return i1.name.compareTo(i2.name);
            }
        });
        return newList;
    }


}
