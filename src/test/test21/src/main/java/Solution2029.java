public class Solution2029 {
    public boolean stoneGameIX(int[] stones) {
        // 求余数 只有两种可能序列：
        // 112121212...
        //  22121212...
        int[] remainders = new int[3];
        for (int stone : stones) {
            remainders[stone % 3] += 1;
        }
        if (remainders[0] % 2 == 0) {
            return Math.min(remainders[1], remainders[2]) > 0;
        }
        return Math.abs(remainders[1] - remainders[2]) > 2;
    }
}
/*
2029. 石子游戏 IX
https://leetcode.cn/problems/stone-game-ix/

第 261 场周赛 T3。

Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，
其中 stones[i] 是第 i 个石子的价值。
Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。

官方题解：https://leetcode.cn/problems/stone-game-ix/solution/guan-jian-zai-yu-qiu-chu-hui-he-shu-by-e-mcgv/
对于回合数，我们只需考虑其奇偶性，因此可以去掉恒为偶数的 min(c[1], c[2])*2。然后我们按照 c[0] 的奇偶性分类讨论：

若 c[0] 为偶数，要使回合数为奇数，c[1] > c[2] 必须不成立，我们可以选择 c[1] 和 c[2] 中的较小值当作第一回合移除的石子，
这样做除了让 c[1] > c[2] 不成立外，由于 c[1]-- 的缘故，还可以使 c[1] != c[2] 成立。
因此在 c[0] 为偶数的情况下，需要满足 min(c[1],c[2])>0 时 Alice 才可以获胜。

若 c[0] 为奇数，要使回合数为奇数，c[1] > c[2] 必须成立。在执行了两次 c[1]-- 后，由于要满足最后的 c[1] != c[2]，
相当于在初始时满足 c[1] - 2 > c[2]。
因此在 c[0] 为奇数的情况下，需要满足 c[1] - 2 > c[2] 或 c[2] - 2 > c[1] 时 Alice 才可以获胜。
 */