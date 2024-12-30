import java.util.Arrays;
import java.util.Comparator;

public class SolutionP2838 {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = heroes.length, m = monsters.length;
        Integer[] hids = new Integer[n];
        Integer[] mids = new Integer[m];
        for (int i = 0; i < n; i++) hids[i] = i;
        for (int i = 0; i < m; i++) mids[i] = i;
        Arrays.sort(hids, Comparator.comparingInt(o -> heroes[o]));
        Arrays.sort(mids, Comparator.comparingInt(o -> monsters[o]));

        long[] ans = new long[n];
        int p1 = 0, p2 = 0;
        long res = 0;
        while (p1 < n) {
            int hid = hids[p1], hero = heroes[hid];
            while (p2 < m) {
                int mid = mids[p2], monster = monsters[mid];
                if (monster > hero) break;
                res += coins[mid];
                p2++;
            }
            ans[hid] = res;
            p1++;
        }
        return ans;
    }
}
/*
$2838. 英雄可以获得的最大金币数
https://leetcode.cn/problems/maximum-coins-heroes-can-collect/description/

在一场战斗中，n 位英雄正在试图击败 m 个怪物。你将得到两个下标从 1 开始的 正整数 数组 heroes 和 monsters，长度分别为 n 和 m。数组 heroes[i] 代表第 i 位英雄的力量，而 monsters[i] 代表第 i 个怪物的力量。
如果 monsters[j] <= heroes[i]，则第 i 位英雄可以击败第 j 个怪物。
你还将获得一个下标从 1 开始的 正整数 数组 coins，长度为 m 。数组 coins[i] 表示每位英雄在击败第 i 个怪物后可以获得的金币数。
返回一个长度为 n 的数组 ans，其中 ans[i] 是第 i 位英雄从这场战斗中能收集到的 最大 金币数。
注意
- 击败怪物后，英雄的生命值不会减少。
- 多位英雄可以击败同一个怪物，但每个怪物只能被同一位英雄击败一次。
提示：
1 <= n == heroes.length <= 10^5
1 <= m == monsters.length <= 10^5
coins.length == m
1 <= heroes[i], monsters[i], coins[i] <= 10^9

排序 + 双指针。
 */