import java.util.Arrays;

public class SolutionP2533 {
    private static final int MOD = (int) (1e9 + 7);
    private int oneGroup, zeroGroup;
    private long[] memo;

    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        this.oneGroup = oneGroup;
        this.zeroGroup = zeroGroup;
        memo = new long[maxLength + 1];
        Arrays.fill(memo, -1);
        long ans = 0;
        for (int x = minLength; x <= maxLength; x++) {
            ans = (ans + dfs(x)) % MOD;
        }
        return (int) ans;
    }

    private long dfs(int i) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (memo[i] != -1) return memo[i];
        long res = dfs(i - oneGroup) + dfs(i - zeroGroup);
        return memo[i] = res % MOD;
    }
}
/*
$2533. 好二进制字符串的数量
https://leetcode.cn/problems/number-of-good-binary-strings/description/

给你四个整数 minLength、maxLength、oneGroup 和 zeroGroup 。
好 二进制字符串满足下述条件：
- 字符串的长度在 [minLength, maxLength] 之间。
- 每块连续 1 的个数是 oneGroup 的整数倍
  - 例如在二进制字符串 00110111100 中，每块连续 1 的个数分别是[2,4] 。
- 每块连续 0 的个数是 zeroGroup 的整数倍
  - 例如在二进制字符串 00110111100 中，每块连续 0 的个数分别是 [2,1,2] 。
请返回 好 二进制字符串的个数。答案可能很大，请返回对 10^9 + 7 取余 后的结果。
注意：0 可以被认为是所有数字的倍数。
提示：
1 <= minLength <= maxLength <= 10^5
1 <= oneGroup, zeroGroup <= maxLength

记忆化搜索。
https://leetcode.cn/problems/number-of-good-binary-strings/solutions/2908140/jian-dan-ji-yi-sou-sou-by-zhi-ma-jie-zha-wtmx/
 */