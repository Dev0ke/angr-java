public class SolutionP2950 {
    public int countDivisibleSubstrings(String word) {
        int n = word.length();
        char[] s = word.toCharArray();
        int[] nums = new int[n];
        int max = 0, min = 9;
        for (int i = 0; i < n; ++i) {
            int x = (s[i] - 'a' + 1) / 3 + 1;
            nums[i] = x;
            if (x > max) max = x;
            if (x < min) min = x;
        }

        if (max == min) return (n * (n + 1)) / 2;

        int base = 9 * n;
        int ans = 0;
        for (int i = min; i <= max; ++i) {
            int[] count = new int[base * 2 + 1];
            count[base] = 1;
            int sum = 0;
            for (int x : nums) {
                sum += x - i;
                ans += count[sum + base]++;
            }
        }
        return ans;
    }
}
/*
$2950. 可整除子串的数量
https://leetcode.cn/problems/number-of-divisible-substrings/description/

每个英文字母都被映射到一个数字，如下所示。
如果字符串的字符的映射值的总和可以被字符串的长度整除，则该字符串是 可整除 的。
给定一个字符串 s，请返回 s 的 可整除子串 的数量。
子串 是字符串内的一个连续的非空字符序列。
提示：
1 <= word.length <= 2000
word 仅包含小写英文字母。

数学 + 计数。
https://leetcode.cn/problems/number-of-divisible-substrings/solutions/2548210/on-shu-xue-ji-shu-java-14ms-by-peaceful-t6s8e/
首先将字符串中的字符转化为数字，然后我们得到一个整数数组 nums。如果一个整数子数组的和能被它的长度整除，那么该整数子数组的平均值为一个整数。而整数数组中的最大值不超过 9，最小值不低于 1，所以可能的平均值最多为 9 个正整数。
假设一个子数组中有 10 个数，平均值为 8，那么 num1+num2+...+num10=10∗8，相当于 (num1−8)+(num2−8)+...+(num10−8)=0。
我们枚举每一个可能的平均值，遍历数组 nums，将数组中的每一个数减去该平均值，然后求区间和为 0 的子数组个数。
时间复杂度 O(n)。
 */