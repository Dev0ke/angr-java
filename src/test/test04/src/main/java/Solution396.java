import java.util.Arrays;

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }

        int ans = f;
        for (int i = n - 1; i >= 0; i--) {
            f += sum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
/*
396. 旋转函数
https://leetcode.cn/problems/rotate-function/description/

给定一个长度为 n 的整数数组 nums 。
假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
返回 F(0), F(1), ..., F(n-1)中的最大值 。
生成的测试用例让答案符合 32 位 整数。
提示:
n == nums.length
1 <= n <= 10^5
-100 <= nums[i] <= 100

迭代。
时间复杂度 O(n)
 */