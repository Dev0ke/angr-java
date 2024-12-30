public class Solution942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int idx = 0;
        int down = 0, up = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[idx++] = s.charAt(i) == 'I' ? down++ : up--;
        }
        ans[idx] = down;
        return ans;
    }
}
/*
942. 增减字符串匹配
https://leetcode.cn/problems/di-string-match/description/

由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
- 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
- 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。

贪心 / 构造题。
时间复杂度 O(n)。
相似题目: $484. 寻找排列
https://leetcode.cn/problems/find-permutation/
2375. 根据模式串构造最小数字
https://leetcode.cn/problems/construct-smallest-number-from-di-string/
 */