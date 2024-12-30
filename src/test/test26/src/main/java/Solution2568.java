import java.util.HashSet;
import java.util.Set;

public class Solution2568 {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        int x = 1;
        while (true) {
            if (!set.contains(x)) {
                return x;
            }
            x <<= 1;
        }
    }
}
/*
2568. 最小无法得到的或值
https://leetcode.cn/problems/minimum-impossible-or/

第 98 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。
如果存在一些整数满足 0 <= index1 < index2 < ... < indexk < nums.length ，得到 nums[index1] | nums[index2] | ... | nums[indexk] = x ，那么我们说 x 是 可表达的 。换言之，如果一个整数能由 nums 的某个子序列的或运算得到，那么它就是可表达的。
请你返回 nums 不可表达的 最小非零整数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

脑筋急转弯。位运算。
只需考虑 二次幂 的数即可，非二次幂都可以由比它小的 二次幂 组合得到。
时间复杂度 O(n + logmax(nums[i]))
空间复杂度 O(n)
 */