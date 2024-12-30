public class Solution2380 {
    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            cnt++;
        }
        return cnt;
    }
}
/*
2380. 二进制字符串重新安排顺序需要的时间
https://leetcode.cn/problems/time-needed-to-rearrange-a-binary-string/

第 85 场双周赛 T2。

给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
请你返回完成这个过程所需要的秒数。
提示：
1 <= s.length <= 1000
s[i] 要么是 '0' ，要么是 '1' 。

暴力模拟
时间复杂度 O(n^2)
 */