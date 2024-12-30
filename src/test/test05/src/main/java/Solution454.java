import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> nums1and2Map = new HashMap<>();
        Map<Integer, Integer> nums3and4Map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                nums1and2Map.put(sum, nums1and2Map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int sum = n3 + n4;
                nums3and4Map.put(sum, nums3and4Map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : nums1and2Map.entrySet()) {
            int sum1 = entry.getKey();
            int sum2 = -sum1;
            if (nums3and4Map.containsKey(sum2)) {
                res += entry.getValue() * nums3and4Map.get(sum2);
            }
        }
        return res;
    }
}
/*
454. 四数相加 II
https://leetcode.cn/problems/4sum-ii/

给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
- 0 <= i, j, k, l < n
- nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 提示：
n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28

nums1/nums2，nums3/nums4 两两组合
时间复杂度 O(n^2)
 */