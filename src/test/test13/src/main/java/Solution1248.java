import java.util.HashMap;
import java.util.Map;

public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        // 预处理
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] % 2;
        }

        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 统计频次
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int pre : preSum) {
            cntMap.put(pre, cntMap.getOrDefault(pre, 0) + 1);
        }

        // "两数之和" 思想
        int res = 0;
        for (int i = 0; i < len + 1; i++) {
            int another = preSum[i] + k;
            if (cntMap.containsKey(another)) {
                res += cntMap.get(another);
            }
        }
        return res;
    }
}
/*
1248. 统计「优美子数组」
https://leetcode.cn/problems/count-number-of-nice-subarrays/

给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
请返回这个数组中 「优美子数组」 的数目。
提示：
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

奇数看作 1，偶数看作 0，求前缀和。
用两数之和思想，时间复杂度 O(n) 内求出 preSum[i] + k == preSum[j] 的数目。
 */