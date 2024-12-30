import java.util.Arrays;

public class SolutionP1085 {
    public int sumOfDigits(int[] nums) {
        int min = Arrays.stream(nums).min().orElseThrow();
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        return (sum % 2 == 1) ? 0 : 1;
    }

}
/*
$1085. 最小元素各数位之和
https://leetcode.cn/problems/sum-of-digits-in-the-minimum-number/

第 2 场双周赛 T1。

给你一个正整数的数组 A。
然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。
提示：
1 <= A.length <= 100
1 <= A[i] <= 100

模拟。
 */