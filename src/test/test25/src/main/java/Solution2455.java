public class Solution2455 {
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            // 能够被 3 整除 && 能被 2 整除
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
/*
2455. 可被三整除的偶数的平均值
https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/

第 317 场周赛 T1。

给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
 */