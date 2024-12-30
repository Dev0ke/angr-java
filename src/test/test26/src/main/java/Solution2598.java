public class Solution2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;

        // 余数频次 0 ~ value-1
        int[] remainCnt = new int[value];
        for (int x : nums) {
            int remain = (x % value + value) % value;
            remainCnt[remain]++;
        }

        for (int i = 0; i <= n; i++) {
            if (remainCnt[i % value] > 0) {
                remainCnt[i % value]--;
            } else {
                return i;
            }
        }
        return n;
    }
}
/*
2598. 执行操作后的最大 MEX
https://leetcode.cn/problems/smallest-missing-non-negative-integer-after-operations/

第 337 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个整数 value 。
在一步操作中，你可以对 nums 中的任一元素加上或减去 value 。
- 例如，如果 nums = [1,2,3] 且 value = 2 ，你可以选择 nums[0] 减去 value ，得到 nums = [-1,2,3] 。
数组的 MEX (minimum excluded) 是指其中数组中缺失的最小非负整数。
- 例如，[-1,2,3] 的 MEX 是 0 ，而 [1,0,3] 的 MEX 是 2 。
返回在执行上述操作 任意次 后，nums 的最大 MEX 。
提示：
1 <= nums.length, value <= 10^5
-10^9 <= nums[i] <= 10^9

贪心。取余后枚举。
 */