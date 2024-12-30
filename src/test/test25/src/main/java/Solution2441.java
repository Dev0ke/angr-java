import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (hashSet.contains(-nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}
/*
2441. 与对应负数同时存在的最大正整数
https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/

第 315 场周赛 T1。

给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
返回正整数 k ，如果不存在这样的整数，返回 -1 。
提示：
1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0

模拟。
 */