public class Solution2180 {
    private int[] dp;

    public int countEven(int num) {
        if (dp == null) {
            dp = new int[1001];
            for (int i = 1; i <= 1000; i++) {
                if (checkEven(i)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[num];
    }

    private boolean checkEven(int num) {
        int sum = 0;
        while (num > 0) {
            int digital = num % 10;
            num /= 10;
            sum += digital;
        }
        return sum % 2 == 0;
    }
}
/*
2180. 统计各位数字之和为偶数的整数个数
https://leetcode.cn/problems/count-integers-with-even-digit-sum/

第 281 场周赛 T1。

给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
提示：
1 <= num <= 1000

模拟，打表。
 */