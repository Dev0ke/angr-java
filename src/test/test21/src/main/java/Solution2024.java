public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] s = answerKey.toCharArray();
        return Math.max(maxConsecutiveChar(s, k, 'T'), maxConsecutiveChar(s, k, 'F'));
    }

    private int maxConsecutiveChar(char[] s, int k, char ch) {
        int n = s.length, l = 0, r = 0, cnt = 0, ans = 0;
        while (r < n) {
            if (s[r] == ch) cnt++;
            if (cnt > k) {
                if (s[l] == ch) cnt--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
2024. 考试的最大困扰度
https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/

第 62 场双周赛 T3。

一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
- 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
提示：
n == answerKey.length
1 <= n <= 5 * 10^4
answerKey[i] 要么是 'T' ，要么是 'F'
1 <= k <= n

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
相似题目: 1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/
 */