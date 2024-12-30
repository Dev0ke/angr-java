public class Solution868 {
    public int binaryGap(int n) {
        int maxLen = 0;
        int lastIdx = -1;
        // int 32bit
        for (int i = 0; i < 32; i++) {
            // >> i 右移 i 位
            // & 1 二进制为 1
            if (((n >> i) & 1) == 1) {
                if (lastIdx >= 0) {
                    maxLen = Math.max(maxLen, i - lastIdx);
                }
                lastIdx = i;
            }
        }
        return maxLen;
    }
}
/*
868. 二进制间距
https://leetcode.cn/problems/binary-gap/

第 93 场周赛 T1。

给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
提示：
1 <= n <= 10^9

((n >> i) & 1) == 1
等价于
((n >> i) % 2) == 1
 */