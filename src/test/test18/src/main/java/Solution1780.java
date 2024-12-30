public class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        return !Integer.toString(n, 3).contains("2");
    }
}
/*
1780. 判断一个数字是否可以表示成三的幂的和
https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/

给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
提示：
1 <= n <= 10^7

进制转换
判定对应三进制是否只有 0 和 1（即没有 2）
 */