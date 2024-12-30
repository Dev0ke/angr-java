import java.util.ArrayList;
import java.util.List;

public class Solution2147 {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                idxList.add(i);
            }
        }

        int cntS = idxList.size();
        if (cntS == 0 || cntS % 2 == 1) {
            return 0;
        }
        int pair = cntS / 2;
        long res = 1;
        int mod = 1000000007;
        for (int i = 0; i < pair - 1; i++) {
            int curRight = idxList.get(i * 2 + 1);
            int nextLeft = idxList.get(i * 2 + 2);
            res = res * (nextLeft - curRight) % mod;
        }
        return (int) res;
    }
}
/*
2147. 分隔长廊的方案数
https://leetcode.cn/problems/number-of-ways-to-divide-a-long-corridor/

第 70 场双周赛 T4。

在一个图书馆的长廊里，有一些座位和装饰植物排成一列。给你一个下标从 0 开始，长度为 n 的字符串 corridor ，它包含字母 'S' 和 'P' ，
其中每个 'S' 表示一个座位，每个 'P' 表示一株植物。
在下标 0 的左边和下标 n - 1 的右边 已经 分别各放了一个屏风。你还需要额外放置一些屏风。
每一个位置 i - 1 和 i 之间（1 <= i <= n - 1），至多能放一个屏风。
请你将走廊用屏风划分为若干段，且每一段内都 恰好有两个座位 ，而每一段内植物的数目没有要求。
可能有多种划分方案，如果两个方案中有任何一个屏风的位置不同，那么它们被视为 不同 方案。
请你返回划分走廊的方案数。由于答案可能很大，请你返回它对 10^9 + 7 取余 的结果。如果没有任何方案，请返回 0 。

乘法、数论取模。
 */