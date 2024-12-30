public class Solution789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int d0 = manhattan(new int[]{0, 0}, target);
        for (int[] p : ghosts) {
            int di = manhattan(p, target);
            if (di <= d0) return false;
        }
        return true;
    }

    private int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
/*
789. 逃脱阻碍者
https://leetcode.cn/problems/escape-the-ghosts/description/

你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。
每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者 同时 到达了一个位置（包括目的地） 都不算 是逃脱成功。
如果不管阻碍者怎么移动都可以成功逃脱时，输出 true ；否则，输出 false 。
提示：
1 <= ghosts.length <= 100
ghosts[i].length == 2
-10^4 <= xi, yi <= 10^4
同一位置可能有 多个阻碍者 。
target.length == 2
-10^4 <= xtarget, ytarget <= 10^4

曼哈顿距离。如果所有的阻碍者和目的地的曼哈顿距离都大于玩家和目的地的曼哈顿距离，则玩家可以在阻碍者之前到达目的地。
时间复杂度 O(n)
 */