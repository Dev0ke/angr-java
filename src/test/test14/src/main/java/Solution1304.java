public class Solution1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int j = 0;
        for (int i = 1; i <= n / 2; i++) {
            ans[j++] = i;
            ans[j++] = -i;
        }
        return ans;
    }
}
/*
1304. 和为零的 N 个不同整数
https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/description/

给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
提示：
1 <= n <= 1000

构造，枚举 相反数即可。
 */