public class SolutionP3155 {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long res = (money[i] + (long) sell[i] * count[i]) / (upgrade[i] + sell[i]);
            ans[i] = (int) Math.min(res, count[i]);
        }
        return ans;
    }
}
/*
$3155. 可升级服务器的最大数量
https://leetcode.cn/problems/maximum-number-of-upgradable-servers/description/

你有 n 个数据中心并且需要升级他们的服务器。
给定四个长度为 n 的数组 count，upgrade，sell 和 money，分别针对每个数据中心表示：
- 服务器的数量
- 升级单个服务器的成本
- 出售服务器获得的钱
- 你最初拥有的钱
返回一个数组 answer，其中对于每个数据中心，answer 中相应的元素代表可以升级的 最大 服务器数量。
请注意，一个数据中心的资金 不能 用于另一个数据中心。
提示：
1 <= count.length == upgrade.length == sell.length == money.length <= 10^5
1 <= count[i], upgrade[i], sell[i], money[i] <= 10^5

解不等式 / 二分答案。
如果升级服务器的总成本不超过可使用的钱，即 upgrade[i]×x≤money[i]+sell[i]×(count[i]−x)，则可以完成升级，否则不能完成升级。
时间复杂度 O(n)。
 */