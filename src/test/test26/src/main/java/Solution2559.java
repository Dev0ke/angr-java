public class Solution2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + (check(words[i]) ? 1 : 0);
        }

        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = preSum[r + 1] - preSum[l];
        }
        return res;
    }

    private boolean check(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
/*
2559. 统计范围内的元音字符串数
https://leetcode.cn/problems/count-vowel-strings-in-ranges/

第 331 场周赛 T2。

给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 40
words[i] 仅由小写英文字母组成
sum(words[i].length) <= 3 * 10^5
1 <= queries.length <= 10^5
0 <= queries[j][0] <= queries[j][1] < words.length

前缀和
 */