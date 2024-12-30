import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));

        int now = 0;
        int ans = 0;
        // 滑动窗口 tiles[i][0] 左端点
        for (int i = 0, j = 0; i < tiles.length; i++) {
            while (j < tiles.length && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
                now += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }
            // 毯子无法完全覆盖第 j 组瓷砖
            if (j < tiles.length) {
                ans = Math.max(ans, now + Math.max(0, tiles[i][0] + carpetLen - tiles[j][0]));
            }
            // 毯子完全覆盖第 j 组瓷砖
            else {
                ans = Math.max(ans, now);
            }
            now -= tiles[i][1] - tiles[i][0] + 1;
        }
        return ans;
    }

    // TLE
    public int maximumWhiteTiles2(int[][] tiles, int carpetLen) {
        int maxLen = 1000000000;
        BitSet bitSet = new BitSet(maxLen + 1);
        for (int[] tile : tiles) {
            bitSet.set(tile[0], tile[1] + 1);
        }

        int max = 0;
        for (int[] tile : tiles) {
            int l = tile[0];
            int r = Math.min(maxLen, tile[0] + carpetLen);
            int cnt = bitSet.get(l, r).cardinality();
            max = Math.max(max, cnt);
        }
        return max;
    }

    private static final int MAX_LEN = 1000000000;

    // 树状数组
    public int maximumWhiteTiles3(int[][] tiles, int carpetLen) {
        Fenwick fenwick = new Fenwick(MAX_LEN);
        for (int[] tile : tiles) {
            fenwick.add(tile[0], tile[1], 1);
        }

        int max = 0;
        for (int[] tile : tiles) {
            max = Math.max(max, fenwick.getsum(tile[0], Math.min(MAX_LEN, tile[0] + carpetLen - 1)));
        }
        return max;
    }

    private static class Fenwick {
        private final int N;
        private final Map<Integer, Integer> t1;
        private final Map<Integer, Integer> t2;

        // O(n) 建树
        public Fenwick(int n) {
            N = n + 1;
            t1 = new HashMap<>();
            t2 = new HashMap<>();
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        // nums[x] add k
        public void add(int x, int k) {
            int v1 = x * k;
            while (x <= N) {
                t1.put(x, t1.getOrDefault(x, 0) + k);
                t2.put(x, t2.getOrDefault(x, 0) + v1);
                x += lowbit(x);
            }
        }

        // nums[l,r] add k
        public void add(int l, int r, int k) {
            add(l, k);
            add(r + 1, -k);
        }

        // nums [1,x] 的和
        public int getsum(Map<Integer, Integer> t, int x) {
            int ans = 0;
            while (x >= 1) {
                ans += t.getOrDefault(x, 0);
                x -= lowbit(x);
            }
            return ans;
        }

        // nums [l,r] 的和
        public int getsum(int l, int r) {
            return (r + 1) * getsum(t1, r) - l * getsum(t1, l - 1) - (getsum(t2, r) - getsum(t2, l - 1));
        }
    }
}
/*
2271. 毯子覆盖的最多白色砖块数
https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/

第 78 场双周赛 T3。

给你一个二维整数数组 tiles ，其中 tiles[i] = [li, ri] ，表示所有在 li <= j <= ri 之间的每个瓷砖位置 j 都被涂成了白色。
同时给你一个整数 carpetLen ，表示可以放在 任何位置 的一块毯子。
请你返回使用这块毯子，最多 可以盖住多少块瓷砖。
提示：
1 <= tiles.length <= 5 * 10^4
tiles[i].length == 2
1 <= li <= ri <= 10^9
1 <= carpetLen <= 10^9
tiles 互相 不会重叠 。

BitSet 模拟 TLE
离散化树状树状 非常勉强。
正解为滑动窗口。
 */