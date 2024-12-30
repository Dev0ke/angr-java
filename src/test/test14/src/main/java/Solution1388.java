import java.util.Arrays;

public class Solution1388 {
    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        int[] slices1 = Arrays.copyOfRange(slices, 0, len - 1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, len);
        // 环形
        return Math.max(rob(slices1, len), rob(slices2, len));
    }

    private int rob(int[] slices, int len) {
        int k = len / 3;
        // f[i][j] 表示从前 i 个数，选择不相邻的 j 个数 的最大值
        int[][] f = new int[len][k + 1];
        // 状态转移
        // 不选 i: f[i][j] = f[i - 1][j]
        // 选择 i: f[i][j] = f[i - 2][j - 1] + slices[i]
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - 2 >= 0) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 2][j - 1] + slices[i - 1]);
                } else {
                    f[i][j] = Math.max(f[i - 1][j], slices[i - 1]);
                }
            }
        }
        return f[len - 1][k];
    }
}
/*
1388. 3n 块披萨
https://leetcode.cn/problems/pizza-with-3n-slices/

给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
- 你挑选 任意 一块披萨。
- Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
- Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
- 重复上述过程直到没有披萨剩下。
- 每一块披萨的大小按顺时针方向由循环数组 slices 表示。
请你返回你可以获得的披萨大小总和的最大值。
提示：
1 <= slices.length <= 500
slices.length % 3 == 0
1 <= slices[i] <= 1000

动态规划 涉及环形数组
时间复杂度 O(n^2)
另有时间复杂度 O(nlogn) 竞赛难度 https://leetcode.cn/problems/pizza-with-3n-slices/solution/3n-kuai-pi-sa-by-leetcode-solution/
相似题目: 213. 打家劫舍 II
https://leetcode.cn/problems/house-robber-ii/
 */