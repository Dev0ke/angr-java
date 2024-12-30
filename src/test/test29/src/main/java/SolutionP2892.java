import java.util.Arrays;

public class SolutionP2892 {
    public int minArrayLength(int[] nums, int k) {
        if (Arrays.stream(nums).min().orElseThrow() == 0) return 1;
        int ans = 0;
        long sm = k + 1;
        for (int v : nums) {
            if (sm * v > k) {
                sm = v;
                ans++;
            } else {
                sm *= v;
            }
        }
        return ans;
    }
}
/*
$2892. 将相邻元素相乘后得到最小化数组
https://leetcode.cn/problems/minimizing-array-after-replacing-pairs-with-their-product/description/

给定一个整数数组 nums 和一个整数 k，你可以对数组执行以下操作任意次数：
- 选择数组中的两个 相邻 元素，例如 x 和 y，使得 x * y <= k ，并用一个值为 x * y 的 单个元素 替换它们（例如，在一次操作中，数组 [1, 2, 2, 3]，其中 k = 5 可以变为 [1, 4, 3] 或 [2, 2, 3]，但不能变为 [1, 2, 6]）。
返回 经过任意次数的操作后， nums 的 最小 可能长度。
约束条件：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
1 <= k <= 10^9

遍历整个数组，尽可能地让当前数和前面的数合并，如果做不到就计数加一。
注意特判 0。
 */