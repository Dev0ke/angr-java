public class Solution1330 {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        // a = nums[i-1], b = nums[i], x = nums[j], y = nums[j+1]
        // d = |a-x| + |b-y| - |a-b| - |x-y|

        // max(a,b) <= min(x,y)
        // d = 2·(mx - mn) >= 0, 其中 mx = min(a,b) 最大值, mn = max(a,b) 最小值
        int base = 0;
        int d = 0;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.max(a, b));
            // i=0, j=n-1
            int i1 = Math.max(Math.abs(nums[0] - b), Math.abs(nums[n - 1] - a));
            d = Math.max(d, i1 - dab);
        }
        return base + Math.max(d, 2 * (mx - mn));
    }
}
/*
1330. 翻转子数组得到最大的数组值
https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/

给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
请你找到可行的最大 数组值 。
提示：
1 <= nums.length <= 3*10^4
-10^5 <= nums[i] <= 10^5

分类讨论。
只有 max(a,b) <= min(x,y) 会影响 d 的最大值
https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/solution/bu-hui-hua-jian-qing-kan-zhe-pythonjavac-c2s6/
时间复杂度 O(n)
 */