public class Solution3084 {
    public long countSubstrings(String s, char c) {
        int cnt = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) cnt++;
        }
        return (cnt + 1L) * cnt / 2;
    }
}
/*
3084. 统计以给定字符开头和结尾的子字符串总数
https://leetcode.cn/problems/count-substrings-starting-and-ending-with-given-character/description/

第 389 场周赛 T2。

给你一个字符串 s 和一个字符 c 。返回在字符串 s 中并且以 c 字符开头和结尾的非空子字符串的总数。
提示：
1 <= s.length <= 10^5
s 和 c 均由小写英文字母组成。

等差数列求和。
设有 k 个字符 c，那么答案为 k+(k-1)+...+1 = k(k+1)/2
时间复杂度 O(n)
 */