import java.util.HashSet;
import java.util.Set;

public class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < len; k++) {
                        if (nums[k] - nums[j] == diff) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // O(n)
    public int arithmeticTriplets2(int[] nums, int diff) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num - diff - diff)) {
                res++;
            }
            set.add(num);
        }
        return res;
    }
}
/*
2367. 算术三元组的数目
https://leetcode.cn/problems/number-of-arithmetic-triplets/

第 305 场周赛 T1。

给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
- i < j < k ，
- nums[j] - nums[i] == diff 且
- nums[k] - nums[j] == diff
返回不同 算术三元组 的数目。
提示：
3 <= nums.length <= 200
0 <= nums[i] <= 200
1 <= diff <= 50
nums 严格 递增

暴力模拟。
时间复杂度 O(n^3)
 */