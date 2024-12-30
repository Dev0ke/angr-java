public class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] cnt = new int[n + 1];
        int[] res = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ai = A[i], bi = B[i];
            cnt[ai]++;
            cnt[bi]++;
            if (cnt[ai] == 2) {
                ans++;
            }
            if (cnt[bi] == 2 && ai != bi) {
                ans++;
            }
            res[i] = ans;
        }
        return res;
    }
}
/*
2657. 找到两个数组的前缀公共数组
https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/

第 103 场双周赛 T2。

给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
请你返回 A 和 B 的 前缀公共数组 。
如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
提示：
1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
题目保证 A 和 B 两个数组都是 n 个元素的排列。

枚举。
时间复杂度 O(n)
 */