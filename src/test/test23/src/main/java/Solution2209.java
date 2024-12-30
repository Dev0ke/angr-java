public class Solution2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        if (numCarpets * carpetLen >= m) {
            return 0;
        }

        // f[i][j] 表示用 i 条地毯覆盖前 j 块板砖时，没被覆盖的白色砖块的最少数目。
        int[][] f = new int[numCarpets + 1][m];
        f[0][0] = floor.charAt(0) == '1' ? 1 : 0;
        for (int j = 1; j < m; j++) {
            f[0][j] = f[0][j - 1] + (floor.charAt(j) == '1' ? 1 : 0);
        }
        for (int i = 1; i <= numCarpets; i++) {
            for (int j = carpetLen * i; j < m; j++) {
                f[i][j] = Math.min(f[i][j - 1] + (floor.charAt(j) == '1' ? 1 : 0), f[i - 1][j - carpetLen]);
            }
        }
        return f[numCarpets][m - 1];
    }

    public int minimumWhiteTiles2(String floor, int numCarpets, int carpetLen) {
        int len = floor.length();
        char[] chars = floor.toCharArray();

        // 剪枝，否则直接贪心会 WA
        if (numCarpets * carpetLen >= len) {
            return 0;
        }

        // 树状数组
        Fenwick fenwick = new Fenwick(len);
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') {
                fenwick.update(i + 1);
            }
        }

        // 贪心
        while (numCarpets > 0) {
            int max = 0;
            int maxIdx = 0;
            for (int i = 0; i + carpetLen <= len; i++) {
                int count1 = fenwick.query(i + carpetLen) - fenwick.query(i);
                if (count1 > max) {
                    max = count1;
                    maxIdx = i;
                }
            }
            for (int i = maxIdx; i < maxIdx + carpetLen && i < len; i++) {
                if (chars[i] == '1') {
                    chars[i] = '0';
                    fenwick.update(i + 1, -1);
                }
            }
            numCarpets--;
        }
        return fenwick.query(len);
    }

    private static class Fenwick {
        int n;
        int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public void update(int x, int inc) {
            while (x <= n) {
                tree[x] += inc;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
2209. 用地毯覆盖后的最少白色砖块
https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/

第 74 场双周赛 T4。

给你一个下标从 0 开始的 二进制 字符串 floor ，它表示地板上砖块的颜色。
- floor[i] = '0' 表示地板上第 i 块砖块的颜色是 黑色 。
- floor[i] = '1' 表示地板上第 i 块砖块的颜色是 白色 。
同时给你 numCarpets 和 carpetLen 。你有 numCarpets 条 黑色 的地毯，每一条 黑色 的地毯长度都为 carpetLen 块砖块。
请你使用这些地毯去覆盖砖块，使得未被覆盖的剩余 白色 砖块的数目 最小 。地毯相互之间可以覆盖。
请你返回没被覆盖的白色砖块的 最少 数目。
提示：
1 <= carpetLen <= floor.length <= 1000
floor[i] 要么是 '0' ，要么是 '1' 。
1 <= numCarpets <= 1000

贪心，但直接贪心是错误的，比赛时被卡用例 2697 / 2698 个通过测试用例，痛失 AK，加一个剪枝判断就 AC 了。
树状树状找出最长连续的 白色砖块，并覆盖地毯，重复 numCarpets 操作
时间复杂度 O(n^2 * logn)
动态规划
时间复杂度 O(nm)。其中 n = numCarpets, m = floor.length()
空间复杂度 O(nm)。
相似题目: C. George and Job
https://codeforces.com/contest/467/problem/C
E. Two Platforms
https://codeforces.com/contest/1409/problem/E
 */