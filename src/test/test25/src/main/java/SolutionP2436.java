public class SolutionP2436 {
    public int minimumSplits(int[] nums) {
        int cnts = 1;
        int g = nums[0];
        for (int val : nums) {
            g = getGCD(g, val);
            if (g == 1) {
                cnts += 1;
                g = val;
            }
        }
        return cnts;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
$2436. 使子数组最大公约数大于一的最小分割数
https://leetcode.cn/problems/minimum-split-into-subarrays-with-gcd-greater-than-one/description/

给定一个由正整数组成的数组 nums。
将数组拆分为 一个或多个 互相不覆盖的子数组，如下所示:
- 数组中的每个元素都 只属于一个 子数组，并且
- 每个子数组元素的 最大公约数 严格大于 1。
返回拆分后可获得的子数组的最小数目。
注意:
- 子数组的 最大公约数 是能将子数组中所有元素整除的最大正整数。
- 子数组 是数组的连续部分。
提示:
1 <= nums.length <= 2000
2 <= nums[i] <= 10^9

一串数组的公约数一定是它子数组的公约数
然后利用这个规则可以贪心
 */