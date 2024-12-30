public class Solution3017 {
    private int[] diff;

    public long[] countOfPairs(int n, int x, int y) {
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        long[] ans = new long[n];
        if (x + 1 >= y) {
            for (int i = 1; i < n; i++) {
                ans[i - 1] = (n - i) * 2L;
            }
            return ans;
        }

        diff = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (i <= x) {
                int k = (x + y + 1) / 2;
                add(1, k - i);
                add(x - i + 2, x - i + y - k);
                add(x - i + 1, x - i + 1 + n - y);
            } else if (i < (x + y) / 2) {
                int k = i + (y - x + 1) / 2;
                add(1, k - i);
                add(i - x + 2, i - x + y - k);
                add(i - x + 1, i - x + 1 + n - y);
            } else {
                add(1, n - i);
            }
        }

        long sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i + 1];
            ans[i] = sumD * 2;
        }
        return ans;
    }

    private void add(int l, int r) {
        diff[l]++;
        diff[r + 1]--;
    }
}
/*
3017. 按距离统计房屋对数目 II
https://leetcode.cn/problems/count-the-number-of-houses-at-a-certain-distance-ii/description/

第 381 场周赛 T4。

给你三个 正整数 n 、x 和 y 。
在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。
对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经过的 最少 街道数为 k 。
返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的 最少 街道数为 k 。
注意，x 与 y 可以 相等 。
提示：
2 <= n <= 10^5
1 <= x, y <= n

分类讨论 + 差分数组
https://leetcode.cn/problems/count-the-number-of-houses-at-a-certain-distance-ii/solutions/2613373/yong-che-xiao-de-fang-shi-si-kao-pythonj-o253
时间复杂度 O(n)
rating 2719 (clist.by)
 */