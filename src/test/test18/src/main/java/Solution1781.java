public class Solution1781 {
    public int beautySum(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        // 前缀和
        int[][] cntArr = new int[len + 1][26];
        for (int i = 0; i < len; i++) {
            int id = chars[i] - 'a';
            cntArr[i + 1] = cntArr[i].clone();
            cntArr[i + 1][id]++;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] cnt = new int[26];
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    cnt[k] = cntArr[j + 1][k] - cntArr[i][k];
                    if (cnt[k] > 0) {
                        max = Math.max(max, cnt[k]);
                        min = Math.min(min, cnt[k]);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
/*
1781. 所有子字符串美丽值之和
https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/

一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
- 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
提示：
1 <= s.length <= 500
s 只包含小写英文字母。

前缀和 * 26
时间复杂度 O(26·n^2)
 */