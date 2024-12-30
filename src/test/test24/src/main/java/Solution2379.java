public class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        // 白块看成 1，答案即长度为 k 时，子数组和的最小值
        int cnt_white = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') cnt_white++;
        }
        int minSum = cnt_white;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') cnt_white--;
            if (blocks.charAt(i) == 'W') cnt_white++;
            minSum = Math.min(minSum, cnt_white);
        }
        return minSum;
    }
}
/*
2379. 得到 K 个黑块的最少涂色次数
https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

第 85 场双周赛 T1。

给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
给你一个整数 k ，表示想要 连续 黑色块的数目。
每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
提示：
n == blocks.length
1 <= n <= 100
blocks[i] 要么是 'W' ，要么是 'B' 。
1 <= k <= n

定长滑动窗口。
时间复杂度 O(n)
 */