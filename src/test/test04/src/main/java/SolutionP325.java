import java.util.HashMap;
import java.util.Map;

public class SolutionP325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 贪心，取前缀和最右边的坐标
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            idxMap.put(preSum[i], i);
        }

        int max = 0;
        for (int i = 0; i < preSum.length; i++) {
            // preSumJp1 - preSumI = k
            int preSumI = preSum[i];
            int preSumJp1 = k + preSumI;
            if (idxMap.containsKey(preSumJp1)) {
                max = Math.max(max, idxMap.get(preSumJp1) - i);
            }
        }
        return max;
    }
}
/*
$325. 和等于 k 的最长子数组长度
https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/

给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
提示：
1 <= nums.length <= 2 * 10^5
-10^4 <= nums[i] <= 10^4
-10^9 <= k <= 10^9

前缀和 + 贪心
 */