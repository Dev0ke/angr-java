public class Solution1359 {
    private static final int MOD = (int) (1e9 + 7);

    public int countOrders(int n) {
        if (n == 1) return 1;
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans * (i * 2L - 1) % MOD * i % MOD;
        }
        return (int) ans;
    }
}
/*
1359. 有效的快递序列数目
https://leetcode.cn/problems/count-all-valid-pickup-and-delivery-options/description/

给你 n 笔订单，每笔订单都需要快递服务。
计算所有有效的 取货 / 交付 可能的顺序，使 delivery(i) 总是在 pickup(i) 之后。
由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
提示：
1 <= n <= 500

递推。
时间复杂度 O(n)。
 */