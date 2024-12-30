public class Solution400 {
    public int findNthDigit(int n) {
        int[] ant = new int[]{0, 10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890};
        int[] numBegin = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for (int i = ant.length - 1; i >= 0; i--) {
            if (n >= ant[i]) {
                int num = (n - ant[i]) / (i + 1) + numBegin[i];
                int posi = (n - ant[i]) % (i + 1);
                return num % (int) Math.pow(10, i + 1 - posi) / (int) Math.pow(10, i - posi);
            }
        }
        return 0;
    }

    // 时间复杂度 O(log10(n))
    public int findNthDigit2(int n) {
        int d = 1;
        int count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }
}
/*
400. 第 N 位数字
https://leetcode.cn/problems/nth-digit/

给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
提示：
1 <= n <= 2^31 - 1
 */