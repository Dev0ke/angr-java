public class Solution3153 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int m = String.valueOf(nums[0]).length();
        int[][] cnt = new int[m][10];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; x > 0; x /= 10, j++) {
                int d = x % 10;
                ans += i - cnt[j][d];
                cnt[j][d]++;
            }
        }
        return ans;
    }
}
/*
3153. 所有数对中数位不同之和
https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/description/

第 398 场周赛 T3。

车尔尼有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
请车尔尼返回 nums 中 所有 整数对里，数位不同之和。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] < 10^9
nums 中的整数都有相同的数位长度。

拆位算贡献 + 一次遍历。
时间复杂度 O(nlogu)。其中 U = nums[0]。
相似题目: 1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 */