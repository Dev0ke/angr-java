public class Solution1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            if (digitLen(v) % 2 == 0) ans++;
        }
        return ans;
    }

    private int digitLen(int x) {
        int len = 0;
        while (x > 0) {
            len++;
            x /= 10;
        }
        return len;
    }
}
/*
1295. 统计位数为偶数的数字
https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/

给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
提示：
1 <= nums.length <= 500
1 <= nums[i] <= 10^5

模拟。
时间复杂度 O(n)。
 */