import java.util.Arrays;

public class SolutionP1885 {
    // O(nlogn)
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] nums1sub2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1sub2[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(nums1sub2);

        // 双指针
        long cnt = 0L;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums1sub2[left] + nums1sub2[right] > 0) {
                cnt += right - left;
                right--;
            } else {
                left++;
            }
        }
        return cnt;
    }

    // O(n^2) TLE
    public long countPairs2(int[] nums1, int[] nums2) {
        int n = nums1.length;

        long cnt = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums1[i] + nums1[j] > nums2[i] + nums2[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
$1885. 统计数对
https://leetcode.cn/problems/count-pairs-in-two-arrays/

给你两个长度为 n 的整数数组 nums1 和 nums2 ，找出所有满足 i < j 且 nums1[i] + nums1[j] > nums2[i] + nums2[j] 的数对 (i, j) 。
返回满足条件数对的 个数 。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 10^5

暴力解法 O(n^2) 显然 TLE
观察 nums1[i] + nums1[j] > nums2[i] + nums2[j] (i<j)
移项 nums1[i] - nums2[i] > nums2[j] - nums1[j] (i<j)
取反 nums1[i] - nums2[i] > -(nums1[j] - nums2[j]) (i<j)
记 nums1sub2[i] = nums1[i] - nums2[i]
则 nums1sub2[i] > -nums1sub2[j] (i<j)
移项 nums1sub2[i] + nums1sub2[j] > 0 (i!=j) 顺序无关
排序+双指针 时间复杂度 O(nlogn)
 */