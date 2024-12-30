import java.util.Arrays;

public class SolutionP2431 {
    private int[] price, tastiness;
    private int[][][] memo;

    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        this.price = price;
        this.tastiness = tastiness;

        int n = price.length;
        memo = new int[n][maxAmount + 1][maxCoupons + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxAmount + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, maxAmount, maxCoupons);
    }

    private int dfs(int i, int ma, int mc) {
        if (i == price.length) return 0;
        if (memo[i][ma][mc] != -1) return memo[i][ma][mc];
        int res = dfs(i + 1, ma, mc); // 不买当前商品
        if (ma >= price[i]) { // 使用全额优惠券购买当前商品
            res = Math.max(res, dfs(i + 1, ma - price[i], mc) + tastiness[i]);
        }
        if (mc > 0 && ma >= price[i] / 2) { // 使用半价优惠券购买当前商品
            res = Math.max(res, dfs(i + 1, ma - price[i] / 2, mc - 1) + tastiness[i]);
        }
        return memo[i][ma][mc] = res;
    }
}
/*
$2431. 最大限度地提高购买水果的口味
https://leetcode.cn/problems/maximize-total-tastiness-of-purchased-fruits/description/

你有两个非负整数数组 price 和 tastiness，两个数组的长度都是 n。同时给你两个非负整数 maxAmount 和 maxCoupons。
对于范围 [0, n - 1] 中的每一个整数 i:
- price[i] 描述了第 i 个水果的价格。
- tastiness[i] 描述了第 i 个水果的味道。
你想购买一些水果，这样总的味道是最大的，总价不超过 maxAmount。
此外，你还可以用优惠券以 半价 购买水果 (向下取整到最接近的整数)。您最多可以使用 maxCoupons 次该优惠券。
返回可购买的最大总口味。
注意:
- 每个水果最多只能购买一次。
- 一个水果你最多只能用一次折价券。
提示:
n == price.length == tastiness.length
1 <= n <= 100
0 <= price[i], tastiness[i], maxAmount <= 1000
0 <= maxCoupons <= 5

记忆化搜索。
https://leetcode.cn/problems/maximize-total-tastiness-of-purchased-fruits/solutions/2786052/python-ji-yi-hua-sou-suo-8xing-by-nrib8z-ddq2/
 */