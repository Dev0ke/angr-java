public class SolutionP2505 {
    public long subsequenceSumOr(int[] nums) {
        long cur = 0;
        long ans = 0;
        for (int v : nums) {
            cur += v;
            ans |= v | cur;
        }
        return ans;
    }
}
/*
$2505. 所有子序列和的按位或
https://leetcode.cn/problems/bitwise-or-of-all-subsequence-sums/description/

给你一个整数数组 nums ，返回对数组中所有可能的 子序列 之和进行按位 或 运算后得到的值。
数组的 子序列 是从数组中删除零个或多个元素且不改变剩余元素的顺序得到的序列。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

第一眼以为是 灵茶八题。。
https://leetcode.cn/problems/bitwise-or-of-all-subsequence-sums/solutions/2021539/zhi-shang-ti-by-wcy23-goa5/
答案为所有输入数字、以及输入数字的所有前缀和的 or。(可能反直觉的一点是按任意顺序求前缀和都是对的。)
 */