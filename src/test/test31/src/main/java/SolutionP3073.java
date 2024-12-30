import java.util.TreeSet;

public class SolutionP3073 {
    public int maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] L = new int[n], R = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < n; i++) {
            set.add(nums[i - 1]);
            Integer lower = set.lower(nums[i]);
            if (lower != null) L[i] = lower;
        }
        int mx = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mx = Math.max(mx, nums[i + 1]);
            if (mx > nums[i]) R[i] = mx;
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (L[i] > 0 && R[i] > 0) {
                ans = Math.max(ans, L[i] - nums[i] + R[i]);
            }
        }
        return ans;
    }
}
/*
$3073. 最大递增三元组
https://leetcode.cn/problems/maximum-increasing-triplet-value/description/

给定一个数组 nums，返回满足 i < j < k 且 nums[i] < nums[j] < nums[k] 的三元组 (i, j, k)  的 最大值。
三元组 (i, j, k)  的 值 为 nums[i] - nums[j] + nums[k]。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
输入数据保证至少一个三元组满足给定条件。

前后缀分解。前缀用平衡树维护最大值，后缀线性取最大值。
时间复杂度 O(nlogn)。
 */