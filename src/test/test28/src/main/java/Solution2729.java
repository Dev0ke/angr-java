import java.util.Arrays;

public class Solution2729 {
    public boolean isFascinating(int n) {
        String s = String.valueOf(n) + (n * 2) + (n * 3);
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }
        int[] expected = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        return Arrays.equals(expected, cnt);
    }
}
/*
2729. 判断一个数是否迷人
https://leetcode.cn/problems/check-if-the-number-is-fascinating/

第 106 场双周赛 T1。

给你一个三位数整数 n 。
如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，那么我们称数字 n 是 迷人的 ：
- 将 n 与数字 2 * n 和 3 * n 连接 。
如果 n 是迷人的，返回 true，否则返回 false 。
连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。
提示：
100 <= n <= 999

字符串模拟。
时间复杂度 O(1) 常数约等于 10。
 */