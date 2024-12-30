public class Solution318 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] flags = new int[len];
        for (int i = 0; i < len; i++) {
            for (char ch : words[i].toCharArray()) {
                flags[i] |= 1 << (ch - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int cur = words[i].length() * words[j].length();
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}
/*
318. 最大单词长度乘积
https://leetcode.cn/problems/maximum-product-of-word-lengths/

给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
提示：
2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] 仅包含小写字母

位运算
将长度为 26 的布尔型数组用 26 个二进制的数位代替, 0 对应 false, 1 对应 true
如果两个整数 flags[i] 和 flags[j] 的与运算结果为 0，那么它们对应的字符串 words[i] 和 words[j] 一定没有相同的字符。
时间复杂度 O(nk+n^2) 其中数组的长度为 n, 平均每个字符串的长度为 k
空间复杂度 O(n)
 */