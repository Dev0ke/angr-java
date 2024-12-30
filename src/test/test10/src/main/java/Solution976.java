import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // 贪心
        for (int i = len - 1; i - 2 >= 0; i--) {
            if (isPerimeter(nums[i], nums[i - 1], nums[i - 2])) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        // 不能形成任何面积不为零的三角形，返回 0
        return 0;
    }

    private boolean isPerimeter(int aLen, int bLen, int cLen) {
        return aLen + bLen > cLen
                && bLen + cLen > aLen
                && aLen + cLen > bLen
                && Math.abs(aLen - bLen) < cLen
                && Math.abs(bLen - cLen) < aLen
                && Math.abs(aLen - cLen) < bLen;
    }
}
/*
976. 三角形的最大周长
https://leetcode.cn/problems/largest-perimeter-triangle/

第 119 场周赛 T2。

给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
如果不能形成任何面积不为零的三角形，返回 0。
提示：
3 <= nums.length <= 10^4
1 <= nums[i] <= 10^6

贪心法。固定大小的滑动窗口。由大到小，第一个符合要求的就是最大周长的三角形。
 */