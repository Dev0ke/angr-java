import java.util.Arrays;

public class SolutionP1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nums1[i] * nums2[n - 1 - i];
        }
        return ans;
    }
}
/*
$1874. 两个数组的最小乘积和
https://leetcode.cn/problems/minimize-product-sum-of-two-arrays/description/

给定两个长度相等的数组a和b，它们的乘积和为数组中所有的a[i] * b[i]之和，其中0 <= i < a.length。
- 比如a = [1,2,3,4]，b = [5,2,3,1]时，它们的乘积和为1*5 + 2*2 + 3*3 + 4*1 = 22
现有两个长度都为n的数组nums1和nums2，你可以以任意顺序排序nums1，请返回它们的最小乘积和。
提示:
n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 100

排序不等式。贪心。
时间复杂度 O(nlogn)。
 */