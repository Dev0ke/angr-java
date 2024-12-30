public class SolutionP487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int l = 0, r = 0;
        int delta = 0, ans = 0;
        while (r < n) {
            delta += 1 ^ nums[r];
            while (delta > 1) {
                delta -= 1 ^ nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
$487. 最大连续1的个数 II
https://leetcode.cn/problems/max-consecutive-ones-ii/

给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
提示:
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1.
进阶：如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？

双指针
相似题目: 485. 最大连续 1 的个数
https://leetcode.cn/problems/max-consecutive-ones/
1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/
 */