public class SolutionP1134 {
    public boolean isArmstrong(int n) {
        String nStr = String.valueOf(n);
        int len = nStr.length();
        int sum = 0;
        for (char ch : nStr.toCharArray()) {
            sum += Math.pow(Integer.parseInt(String.valueOf(ch)), len);
        }
        return sum == n;
    }
}
/*
$1134. 阿姆斯特朗数
https://leetcode.cn/problems/armstrong-number/

第 5 场双周赛 T2。

假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
提示：
1 <= n <= 10^8

模拟。
 */