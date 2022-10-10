package qunaer;

public class exam1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 运动员可得到的最高分
     * @param energy int整型 运动员体力值
     * @param actions int整型二维数组 二维数组i为动作号 actions[i][0]为动作i+1消耗体力,actions[i][1]为动作i+1得分
     * @return int整型
     */
    int res = 0;
    public int maxScore (int energy, int[][] actions) {
        // write code here
        dfs(0, actions, energy, 0);
        return res;
    }

    public void dfs(int i, int[][] actions, int energy, int score) {
        if (energy < 0) {
            return ;
        }
        if (i >= actions.length) {
            res = Math.max(score, res);
            return ;
        }
        dfs(i + 1, actions, energy, score);
        if (energy - actions[i][0] >= 0) {
            dfs(i + 1, actions, energy - actions[i][0], score + actions[i][1]);
        }
    }
}
