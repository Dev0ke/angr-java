import java.util.Arrays;

public class Solution2475 {
    public int unequalTriplets(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    // 时间复杂度 O(nlogn)
    public int unequalTriplets2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int pre = 0;
        for (int i = 0; i + 1 < len; i++) {
            if (nums[i] != nums[i + 1]) {
                res += pre * (i - pre + 1) * (len - 1 - i);
                pre = i + 1;
            }
        }
        return res;
    }
}
/*
2475. 数组中不等三元组的数目
https://leetcode.cn/problems/number-of-unequal-triplets-in-array/

第 320 场周赛 T1。

给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
- 0 <= i < j < k < nums.length
- nums[i]、nums[j] 和 nums[k] 两两不同 。
  - 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
返回满足上述条件三元组的数目。
提示：
3 <= nums.length <= 100
1 <= nums[i] <= 1000

暴力
时间复杂度 O(n^3)
另有 时间复杂度 O(nlogn) 的解法
 */