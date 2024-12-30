import java.util.Arrays;

public class Solution611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 因为 a <= b <= c
                // 必定 a+c>b, b+c>a, 只需再满足 a+b>c

                int left = j + 1;
                int right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    if (nums[mid] >= nums[i] + nums[j]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                cnt += (left - 1) - j;
            }
        }
        return cnt;
    }
}
/*
611. 有效三角形的个数
https://leetcode.cn/problems/valid-triangle-number/

给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
提示:
1 <= nums.length <= 1000
0 <= nums[i] <= 1000

排序后二分查找第三边。
时间复杂度 O(n^2logn)
 */