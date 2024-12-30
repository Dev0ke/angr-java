import java.util.ArrayList;
import java.util.List;

public class Solution1434 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        // 找到帽子编号的最大值，这样我们只需要求出 f[maxhatid][2^n - 1] 作为答案
        int maxHatId = 0;
        for (List<Integer> hat : hats) {
            for (int ha : hat) {
                maxHatId = Math.max(maxHatId, ha);
            }
        }

        // 对于每一顶帽子 h，hatToPerson[h] 中存储了喜欢这顶帽子的所有人，方便进行动态规划
        List<List<Integer>> hatToPerson = new ArrayList<>();
        for (int i = 0; i <= maxHatId; i++) {
            hatToPerson.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (int h : list) {
                hatToPerson.get(h).add(i);
            }
        }

        // f[i][mask] 表示我们处理了前 i 顶帽子，并且已经被分配帽子的人的状态为 mask 时的方案数
        int[][] f = new int[maxHatId + 1][1 << n];
        // 边界条件
        f[0][0] = 1;
        for (int i = 1; i <= maxHatId; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                f[i][mask] = f[i - 1][mask];
                List<Integer> list = hatToPerson.get(i);
                for (int j : list) {
                    if ((mask & (1 << j)) != 0) {
                        f[i][mask] += f[i - 1][mask ^ (1 << j)];
                        f[i][mask] %= MOD;
                    }
                }
            }
        }

        return f[maxHatId][(1 << n) - 1];
    }
}
/*
1434. 每个人戴不同帽子的方案数
https://leetcode.cn/problems/number-of-ways-to-wear-different-hats-to-each-other/

总共有 n 个人和 40 种不同的帽子，帽子编号从 1 到 40 。
给你一个整数列表的列表 hats ，其中 hats[i] 是第 i 个人所有喜欢帽子的列表。
请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数。
由于答案可能很大，请返回它对 10^9 + 7 取余后的结果。
提示：
n == hats.length
1 <= n <= 10
1 <= hats[i].length <= 40
1 <= hats[i][j] <= 40
hats[i] 包含一个数字互不相同的整数列表。

状态压缩动态规划
 */