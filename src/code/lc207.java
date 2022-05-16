package code;

import org.junit.Test;

import java.util.*;

public class lc207 {
    Map<Integer, Integer> preReqMap = new HashMap<>();
    Set<Integer> finishSet = new HashSet<>();
    int numCourses;
    @Test
    public void lc207() {
        int numCourses = 3;
        int[][] prerequisites = new int[][] {{1, 0}, {1, 2}, {0, 1}};
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            indegree[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            int idx = queue.pollFirst();
            indegree[idx]--;
            numCourses--;
            for (int i : adjacency.get(idx)) {
                if (--indegree[i] == 0) queue.addLast(i);
            }
        }
        return numCourses==0;
    }

    public void preCourse(int num) {
        if (!finishSet.contains(num) && numCourses >= 0) {
            numCourses--;
            if (preReqMap.containsKey(num)) {
                preCourse(preReqMap.get(num));
                if (finishSet.contains(preReqMap.get(num)))
                    finishSet.add(num);

            } else
                finishSet.add(num);
        }
        return ;
    }
}
