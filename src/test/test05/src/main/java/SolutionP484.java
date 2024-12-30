public class SolutionP484 {
    public int[] findPermutation(String s) {
        int n = s.length();

        int[] res = new int[n + 1];
        int cur = 1;
        int idx = 0;
        while (idx < n) {
            if (idx > 0 && s.charAt(idx) == 'I') {
                idx++;
            }
            while (idx < n && s.charAt(idx) == 'I') {
                res[idx] = cur++;
                idx++;
            }
            int i0 = idx;
            while (idx < n && s.charAt(idx) == 'D') {
                idx++;
            }
            for (int j = idx; j >= i0; j--) {
                res[j] = cur++;
            }
        }
        return res;
    }
}
/*
$484. 寻找排列
https://leetcode.cn/problems/find-permutation/

由范围 [1,n] 内所有整数组成的 n 个整数的排列 perm 可以表示为长度为 n - 1 的字符串 s ，其中:
- 如果 perm[i] < perm[i + 1] ，那么 s[i] == ' i '
- 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 。
给定一个字符串 s ，重构字典序上最小的排列 perm 并返回它。
提示：
1 <= s.length <= 10^5
s[i] 只会包含字符 'D' 和 'I'。

贪心，数组翻转。
时间复杂度 O(n)
相似题目: 2375. 根据模式串构造最小数字
https://leetcode.cn/problems/construct-smallest-number-from-di-string/
 */