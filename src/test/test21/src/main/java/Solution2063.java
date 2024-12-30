public class Solution2063 {
    public long countVowels(String word) {
        int len = word.length();
        long res = 0;
        for (int i = 0; i < len; i++) {
            if ("aeiou".indexOf(word.charAt(i)) >= 0) {
                res += (long) (i + 1) * (len - i);
            }
        }
        return res;
    }
}
/*
2063. 所有子字符串中的元音
https://leetcode.cn/problems/vowels-of-all-substrings/

第 266 场周赛 T2。

给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
子字符串 是字符串中一个连续（非空）的字符序列。
注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
提示：
1 <= word.length <= 10^5
word 由小写英文字母组成

由于 word.length <= 10^5，所以本题使用 暴力+前缀和 O(n^2) 会 TLE。
对于每个下标为 i 的元音字母，在子字符串中贡献了 (i + 1) * (n - i) 次。
时间复杂度 O(n)
 */