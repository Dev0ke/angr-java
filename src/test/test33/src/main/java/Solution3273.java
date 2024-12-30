import java.util.Arrays;

public class Solution3273 {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            long ti = (health[i] + power - 1L) / power;
            a[i] = new Node(damage[i], ti);
        }
        Arrays.sort(a, (o1, o2) -> Long.compare(o2.dam * o1.time, o1.dam * o2.time));

        long ans = 0;
        long seconds = 0;
        for (int i = 0; i < n; i++) {
            seconds += a[i].time;
            ans += a[i].dam * seconds;
        }
        return ans;
    }

    static class Node {
        long dam, time;

        public Node(long dam, long time) {
            this.dam = dam;
            this.time = time;
        }
    }
}
/*
3273. 对 Bob 造成的最少伤害
https://leetcode.cn/problems/minimum-amount-of-damage-dealt-to-bob/description/

第 138 场双周赛 T4。

给你一个整数 power 和两个整数数组 damage 和 health ，两个数组的长度都为 n 。
Bob 有 n 个敌人，如果第 i 个敌人还活着（也就是健康值 health[i] > 0 的时候），每秒钟会对 Bob 造成 damage[i] 点 伤害。
每一秒中，在敌人对 Bob 造成伤害 之后 ，Bob 会选择 一个 还活着的敌人进行攻击，该敌人的健康值减少 power 。
请你返回 Bob 将 所有 n 个敌人都消灭之前，最少 会收到多少伤害。
提示：
1 <= power <= 10^4
1 <= n == damage.length == health.length <= 10^5
1 <= damage[i], health[i] <= 10^4

贪心。邻项交换法 证明。
相似题目: 3219. 切蛋糕的最小总开销 II
https://leetcode.cn/problems/minimum-cost-for-cutting-cake-ii/description/
 */