import java.util.List;
import java.util.TreeSet;

public class Solution2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));
            Integer v = nums.get(i);
            Integer floor = set.floor(v);
            if (floor != null) {
                ans = Math.min(ans, v - floor);
            }
            Integer ceiling = set.ceiling(v);
            if (ceiling != null) {
                ans = Math.min(ans, ceiling - v);
            }
        }
        return ans;
    }
}
/*
2817. 限制条件下元素之间的最小绝对差
https://leetcode.cn/problems/minimum-absolute-difference-between-elements-with-constraint/

第 358 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums 和一个整数 x 。
请你找到数组中下标距离至少为 x 的两个元素的 差值绝对值 的 最小值 。
换言之，请你找到两个下标 i 和 j ，满足 abs(i - j) >= x 且 abs(nums[i] - nums[j]) 的值最小。
请你返回一个整数，表示下标距离至少为 x 的两个元素之间的差值绝对值的 最小值 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= x < nums.length

平衡树 + 双指针。滑动窗口控制加入平衡树时机。
 */