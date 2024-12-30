import java.util.Arrays;

public class Solution546 {
    private int[] boxes;
    private int[][][] memo;

    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        this.boxes = boxes;

        memo = new int[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return f(0, len - 1, 0);
    }

    // f(l,r,k) 表示移除区间 [l,r] 的元素 加上该区间右边等于 ar 的 k 个元素组成的这个序列的最大积分
    private int f(int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r][k] != -1) {
            return memo[l][r][k];
        }

        int r1 = r;
        int k1 = k;
        while (r1 > l && boxes[r1] == boxes[r1 - 1]) {
            r1--;
            k1++;
        }
        int max = f(l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);
        for (int i = l; i < r1; i++) {
            if (boxes[i] == boxes[r1]) {
                max = Math.max(max, f(l, i, k1 + 1) + f(i + 1, r1 - 1, 0));
            }
        }
        memo[l][r][k] = max;
        return max;
    }
}
/*
546. 移除盒子
https://leetcode.cn/problems/remove-boxes/

给出一些不同颜色的盒子 boxes ，盒子的颜色由不同的正数表示。
你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k * k 个积分。
返回 你能获得的最大积分和 。
提示：
1 <= boxes.length <= 100
1 <= boxes[i] <= 100

区间 DP / 记忆化搜索
时间复杂度 O(n^4)
空间复杂度 O(n^3)
 */