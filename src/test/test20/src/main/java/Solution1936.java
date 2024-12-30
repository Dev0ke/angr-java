public class Solution1936 {
    public int addRungs(int[] rungs, int dist) {
        int len = rungs.length;
        // 差分数组
        int[] diff = new int[len];
        diff[0] = rungs[0];
        for (int i = 1; i < len; i++) {
            diff[i] = rungs[i] - rungs[i - 1];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (diff[i] > dist) {
                int mod = diff[i] % dist;
                if (mod == 0) {
                    // [0, 4] 2 => 0 2 4 即可，整除情况需 -1
                    res += diff[i] / dist - 1;
                } else {
                    // [0, 5] 2 => 0 2 4 5 取除数即可
                    res += diff[i] / dist;
                }
            }
        }
        return res;
    }
}
/*
1936. 新增的最少台阶数
https://leetcode.cn/problems/add-minimum-number-of-rungs/

第 250 场周赛 T2。

给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过 dist 高度的台阶。当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
返回爬到最后一阶时必须添加到梯子上的 最少 台阶数。
提示：
1 <= rungs.length <= 10^5
1 <= rungs[i] <= 10^9
1 <= dist <= 10^9
rungs 严格递增

差分数组。
时间复杂度 O(n)
 */