import java.util.ArrayList;
import java.util.List;

public class Solution1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();

        // 奇偶性
        int[][] preSum = new int[len + 1][26];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                preSum[i + 1][j] = preSum[i][j];
            }
            int id = s.charAt(i) - 'a';
            preSum[i + 1][id] = preSum[i][id] + 1;
        }

        List<Boolean> resList = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];

            int odd = 0;
            for (int j = 0; j < 26; j++) {
                int cnt = preSum[right + 1][j] - preSum[left][j];
                if (cnt % 2 == 1) {
                    odd++;
                }
            }
            // 一次替换操作最多处理 2 个奇数，3 个奇数需要 2 次，最多可以剩下不超过 1 个奇数
            resList.add(odd / 2 <= k);
        }
        return resList;
    }
}
/*
1177. 构建回文串检测
https://leetcode.cn/problems/can-make-palindrome-from-substring/

给你一个字符串 s，请你对 s 的子串进行检测。
每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。
（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
提示：
1 <= s.length, queries.length <= 10^5
0 <= queries[i][0] <= queries[i][1] < s.length
0 <= queries[i][2] <= s.length
s 中只有小写英文字母

前缀和思想
在时间复杂度 O(1) 内（常数 26）求出 区间内各字符数量
 */