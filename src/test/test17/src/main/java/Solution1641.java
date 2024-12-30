public class Solution1641 {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
/*
1641. 统计字典序元音字符串的数目
https://leetcode.cn/problems/count-sorted-vowel-strings/

第 213 场周赛 T2。

给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
提示：
1 <= n <= 50

找规律。
 */