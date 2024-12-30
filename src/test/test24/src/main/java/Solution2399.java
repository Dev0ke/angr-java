import java.util.Arrays;

public class Solution2399 {
    public boolean checkDistances(String s, int[] distance) {
        int len = s.length();
        // 第一次出现的下标
        int[] first = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] != -1 && i - first[idx] - 1 != distance[idx]) {
                return false;
            } else {
                first[idx] = i;
            }
        }
        return true;
    }
}
/*
2399. 检查相同字母间的距离
https://leetcode.cn/problems/check-distances-between-same-letters/

第 309 场周赛 T1。

给你一个下标从 0 开始的字符串 s ，该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次 。另给你一个下标从 0 开始、长度为 26 的的整数数组 distance 。
字母表中的每个字母按从 0 到 25 依次编号（即，'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25）。
在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i] 。如果第 i 个字母没有在 s 中出现，那么 distance[i] 可以 忽略 。
如果 s 是一个 匀整 字符串，返回 true ；否则，返回 false 。
提示：
2 <= s.length <= 52
s 仅由小写英文字母组成
s 中的每个字母恰好出现两次
distance.length == 26
0 <= distance[i] <= 50

模拟。
时间复杂度 O(1)
 */