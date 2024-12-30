import java.util.Arrays;

public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] wordsF = new int[n];
        for (int i = 0; i < n; i++) {
            wordsF[i] = f(words[i]);
        }
        Arrays.sort(wordsF);

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int queryF = f(queries[i]);

            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (wordsF[mid] > queryF) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = n - left;
        }
        return ans;
    }

    private int f(String s) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] > 0) {
                return cntArr[i];
            }
        }
        return 0;
    }
}
/*
1170. 比较字符串最小字母出现频次
https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/

定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
提示：
1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j]、words[i][j] 都由小写英文字母组成

模拟。对于每次查询 二分找结果。
时间复杂度 O(nlogn + (n+q) * C) 其中 C = queries[i].length, words[i].length 最大为 10
 */