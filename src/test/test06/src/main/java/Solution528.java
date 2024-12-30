import java.util.Random;

public class Solution528 {
    static class Solution {
        private final int[] preSum;
        private int total;

        public Solution(int[] w) {
            preSum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                preSum[i] = total;
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int p = random.nextInt(total);

            int left = 0;
            int right = preSum.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (preSum[mid] > p) {
                    if (mid == 0 || preSum[mid - 1] <= p) {
                        return mid;
                    }
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
/*
528. 按权重随机选择
https://leetcode.cn/problems/random-pick-with-weight/

给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
提示：
1 <= w.length <= 10^4
1 <= w[i] <= 10^5
pickIndex 将被调用不超过 10^4 次

前缀和 + 二分查找
 */