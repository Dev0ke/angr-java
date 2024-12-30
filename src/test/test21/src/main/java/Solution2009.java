import java.util.Arrays;

public class Solution2009 {
    // https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/solutions/1005398/on-zuo-fa-by-endlesscheng-l7yi
    public int minOperations(int[] nums) {
        int n = nums.length;
        nums = sortAndUnique(nums);
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            int l = searchInts(nums, 0, r, nums[r] - n + 1);
            ans = Math.max(ans, r - l + 1);
        }
        return n - ans;
    }

    // 原地去重
    private int[] sortAndUnique(int[] a) {
        Arrays.sort(a);
        int k = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[k] != a[i]) {
                a[++k] = a[i];
            }
        }
        return Arrays.copyOfRange(a, 0, k + 1);
    }

    // Params:
    // a – the array to be searched
    // fromIndex – the index of the first element (inclusive) to be searched
    // toIndex – the index of the last element (exclusive) to be searched
    // key – the value to be searched for
    private int searchInts(int[] a, int from, int to, int key) {
        int l = 0, r = to - from;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[from + m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2009. 使数组连续的最少操作数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/

第 61 场双周赛 T4。

给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
如果 nums 满足以下条件，那么它是 连续的 ：
- nums 中所有元素都是 互不相同 的。
- nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
请你返回使 nums 连续 的 最少 操作次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

排序 + 去重 + 二分
时间复杂度 O(nlogn)。
 */