import java.util.HashMap;
import java.util.Map;

public class Solution1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return getAns(nums1, nums2) + getAns(nums2, nums1);
    }

    private int getAns(int[] nums1, int[] nums2) {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int x : nums1) {
            long prod = (long) x * x;
            cntMap.put(prod, cntMap.getOrDefault(prod, 0) + 1);
        }
        int n = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long prod = (long) nums2[i] * nums2[j];
                ans += cntMap.getOrDefault(prod, 0);
            }
        }
        return ans;
    }
}
/*
1577. 数的平方等于两数乘积的方法数
https://leetcode.cn/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/description/

给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
- 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
- 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
提示：
1 <= nums1.length, nums2.length <= 1000
1 <= nums1[i], nums2[i] <= 10^5

哈希表
时间复杂度 O(mn)
空间复杂度 O(m+n)
 */