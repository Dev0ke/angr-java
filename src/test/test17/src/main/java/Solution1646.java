import java.util.Arrays;

public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            if (i % 2 == 0) nums[i] = nums[i / 2];
            else nums[i] = nums[i / 2] + nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().orElseThrow();
    }
}
/*
1646. 获取生成数组中的最大值
https://leetcode.cn/problems/get-maximum-in-generated-array/description/

给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
- nums[0] = 0
- nums[1] = 1
- 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
- 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
返回生成数组 nums 中的 最大 值。
提示：
0 <= n <= 100

2*i 必定是偶数，2*i+1 必定是奇数。转化一下即可，
时间复杂度 O(n)。
 */