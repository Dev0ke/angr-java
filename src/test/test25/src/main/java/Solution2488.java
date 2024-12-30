import java.util.HashMap;
import java.util.Map;

public class Solution2488 {
    public int countSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        int kId = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > k) {
                arr[i] = 1;
            } else if (nums[i] < k) {
                arr[i] = -1;
            } else {
                kId = i;
            }
        }

        int[] preSum = new int[len + 1];
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
            if (i >= kId) {
                cntMap.put(preSum[i + 1], cntMap.getOrDefault(preSum[i + 1], 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i <= kId; i++) {
//            for (int j = kId; j < len; j++) {
//                int sum = preSum[j + 1] - preSum[i];
//                if (sum == 0 || sum == 1) {
//                    res++;
//                }
//            }
            res += cntMap.getOrDefault(preSum[i], 0);
            res += cntMap.getOrDefault(preSum[i] + 1, 0);
        }
        return res;
    }
}
/*
2488. 统计中位数为 K 的子数组
https://leetcode.cn/problems/count-subarrays-with-median-k/

第 321 场周赛 T4。

给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
统计并返回 num 中的 中位数 等于 k 的非空子数组的数目。
注意：
- 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
  - 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
- 子数组是数组中的一个连续部分。
提示：
n == nums.length
1 <= n <= 10^5
1 <= nums[i], k <= n
nums 中的整数互不相同

贪心 + 前缀和
设区间 [l,r] 内比 k 大的数有 a 个，比 k 小的数有 b 个
当 0 <= b-a <= 1 时，区间满足要求（其中 l 取值范围为 [0, ki], r 取值范围为 [ki, n-1]）。
使用前缀和预处理，可在 时间复杂度 O(n^2) 内求出 区间 [l,r] 是否符合要求。
注意到 l <= ki <= r，可使用 HashMap 预处理 r 的所有可能取值及频次进行优化。
时间复杂度 O(n)。
 */