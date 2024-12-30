import java.util.Arrays;

public class SolutionP2229 {
    public boolean isConsecutive(int[] nums) {
        int n = nums.length;
        long counted = Arrays.stream(nums).distinct().count();
        int span = Arrays.stream(nums).max().orElseThrow() - Arrays.stream(nums).min().orElseThrow() + 1;
        return n == counted && n == span;
    }
}
/*
$2229. 检查数组是否连贯
https://leetcode.cn/problems/check-if-an-array-is-consecutive/description/

给你一个整数数组 nums ，如果 nums 是一个 连贯数组 ，则返回 true ，否则返回 false 。
如果数组包含 [x, x + n - 1] 范围内的所有数字（包括 x 和 x + n - 1 ），则该数组为连贯数组；其中 x 是数组中最小的数，n 是数组的长度。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

满足题目条件只有一种情况，数组最大值比最小值大 n-1 且 数组中无重复元素
 */