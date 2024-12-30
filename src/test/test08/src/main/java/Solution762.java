import java.util.Set;

public class Solution762 {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> hashSet = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (hashSet.contains(Integer.bitCount(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
762. 二进制表示中质数个计算置位
https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/

给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
计算置位位数 就是二进制表示中 1 的个数。
- 例如， 21 的二进制表示 10101 有 3 个计算置位。
提示：
1 <= left <= right <= 10^6
0 <= right - left <= 10^4

int 二进制表示中 1 的个数 不会超过 31，可将 31 以内的质数都列出来，枚举判断即可。
 */