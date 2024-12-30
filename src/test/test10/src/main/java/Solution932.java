import java.util.HashMap;
import java.util.Map;

public class Solution932 {
    private Map<Integer, int[]> memo;

    public int[] beautifulArray(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }

    // A[k] * 2 = A[i] + A[j], i < k < j
    // 因为 A[k] * 2 恒为偶数，可以让 left 部分的数都是奇数，right 部分的数都是偶数。
    private int[] dfs(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int j = 0;
            for (int x : dfs((n + 1) / 2)) { // odds
                ans[j++] = x * 2 - 1;
            }
            for (int x : dfs(n / 2)) { // evens
                ans[j++] = x * 2;
            }
        }
        memo.put(n, ans);
        return ans;
    }
}
/*
932. 漂亮数组
https://leetcode.cn/problems/beautiful-array/description/

如果长度为 n 的数组 nums 满足下述条件，则认为该数组是一个 漂亮数组 ：
- nums 是由范围 [1, n] 的整数组成的一个排列。
- 对于每个 0 <= i < j < n ，均不存在下标 k（i < k < j）使得 2 * nums[k] == nums[i] + nums[j] 。
给你整数 n ，返回长度为 n 的任一 漂亮数组 。本题保证对于给定的 n 至少存在一个有效答案。
提示：
1 <= n <= 1000

分治
时间复杂度 O(mlogn)。
 */