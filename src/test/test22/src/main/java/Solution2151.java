import java.util.HashSet;
import java.util.Set;

public class Solution2151 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;

        int max = 0;
        // 状态压缩 2^15 = 32768
        for (int state = 0; state < (1 << n); state++) {
            // 二进制 1 的个数，1 代表选取
            int i = Integer.bitCount(state);

            if (check(statements, state)) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    private boolean check(int[][] statements, int state) {
        int n = statements.length;
        Set<Integer> goodMan = new HashSet<>();
        for (int k = 0; k < n; k++) {
            if (((state >> k) & 1) > 0) {
                goodMan.add(k);
            }
        }
        for (int good : goodMan) {
            for (int i = 0; i < n; i++) {
                int statement = statements[good][i];
                // 0 表示 i 的陈述认为 j 是 坏人 。
                if (statement == 0 && goodMan.contains(i)) {
                    return false;
                }
                // 1 表示 i 的陈述认为 j 是 好人 。
                if (statement == 1 && !goodMan.contains(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
2151. 基于陈述统计最多好人数
https://leetcode.cn/problems/maximum-good-people-based-on-statements/

第 277 场周赛 T4。

游戏中存在两种角色：
- 好人：该角色只说真话。
- 坏人：该角色可能说真话，也可能说假话。
给你一个下标从 0 开始的二维整数数组 statements ，大小为 n x n ，表示 n 个玩家对彼此角色的陈述。具体来说，statements[i][j] 可以是下述值之一：
- 0 表示 i 的陈述认为 j 是 坏人 。
- 1 表示 i 的陈述认为 j 是 好人 。
- 2 表示 i 没有对 j 作出陈述。
另外，玩家不会对自己进行陈述。形式上，对所有 0 <= i < n ，都有 statements[i][i] = 2 。
根据这 n 个玩家的陈述，返回可以认为是 好人 的 最大 数目。
提示：
n == statements.length == statements[i].length
2 <= n <= 15
statements[i][j] 的值为 0、1 或 2
statements[i][i] == 2

看数据范围猜想是状态压缩。二进制 1 表示好人，0 表示坏人。由于坏人可能说真话，也可能说假话，因此不需关注坏人，只需关注好人之间逻辑是否自洽即可。
贪心取最大值。
时间复杂度 O(2^n)
相似题目: 2035. 将数组分成两个数组并最小化数组和的差
https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */