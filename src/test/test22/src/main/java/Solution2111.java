import java.util.ArrayList;
import java.util.List;

public class Solution2111 {
    public int kIncreasing(int[] arr, int k) {
        int len = arr.length;
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < len; j += k) {
                list.add(arr[j]);
            }
            cnt += lengthOfLIS(list);
        }
        return len - cnt;
    }

    public int lengthOfLIS(List<Integer> nums) {
        List<Integer> a = new ArrayList<>();
        for (int x : nums) {
            int j = upperBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
        }
        return a.size();
    }

    private int upperBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2111. 使数组 K 递增的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-the-array-k-increasing/

第 272 场周赛 T4。

给你一个下标从 0 开始包含 n 个正整数的数组 arr ，和一个正整数 k 。
如果对于每个满足 k <= i <= n-1 的下标 i ，都有 arr[i-k] <= arr[i] ，那么我们称 arr 是 K 递增 的。
- 比方说，arr = [4, 1, 5, 2, 6, 2] 对于 k = 2 是 K 递增的，因为：
 - arr[0] <= arr[2] (4 <= 5)
 - arr[1] <= arr[3] (1 <= 2)
 - arr[2] <= arr[4] (5 <= 6)
 - arr[3] <= arr[5] (2 <= 2)
- 但是，相同的数组 arr 对于 k = 1 不是 K 递增的（因为 arr[0] > arr[1]），对于 k = 3 也不是 K 递增的（因为 arr[0] > arr[3] ）。
每一次 操作 中，你可以选择一个下标 i 并将 arr[i] 改成任意 正整数。
请你返回对于给定的 k ，使数组变成 K 递增的 最少操作次数 。
提示：
1 <= arr.length <= 10^5
1 <= arr[i], k <= arr.length

范围 10^5 可以接受 O(n) 或 O(nlogn) 的时间复杂度算法。比赛时一根筋想 O(n) 的贪心上去了。。
分块求各块 LIS 长度的和，再用总长度减去 即为答案。
LIS 的时间复杂度需为贪心+二分的 O(nlogn) 而不能是 动态规划的 O(n^2)

相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */