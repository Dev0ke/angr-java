public class Solution2167 {
    public int minimumTime(String s) {
        int n = s.length();

        // 前后缀分解
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int pre0 = (i - 1 >= 0 ? pre[i - 1] : 0);
            if (s.charAt(i) == '0') pre[i] = pre0;
            else pre[i] = Math.min(pre0 + 2, i + 1);
        }
        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') suf[i] = suf[i + 1];
            else suf[i] = Math.min(suf[i + 1] + 2, n - i);
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, pre[i] + suf[i]);
        }
        return ans;
    }
}
/*
2167. 移除所有载有违禁货物车厢所需的最少时间
https://leetcode.cn/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/

第 279 场周赛 T4。

给你一个下标从 0 开始的二进制字符串 s ，表示一个列车车厢序列。s[i] = '0' 表示第 i 节车厢 不 含违禁货物，而 s[i] = '1' 表示第 i 节车厢含违禁货物。
作为列车长，你需要清理掉所有载有违禁货物的车厢。你可以不限次数执行下述三种操作中的任意一个：
1.从列车 左 端移除一节车厢（即移除 s[0]），用去 1 单位时间。
2.从列车 右 端移除一节车厢（即移除 s[s.length - 1]），用去 1 单位时间。
3.从列车车厢序列的 任意位置 移除一节车厢，用去 2 单位时间。
返回移除所有载有违禁货物车厢所需要的 最少 单位时间数。
注意，空的列车车厢序列视为没有车厢含违禁货物。

前后缀分解 + DP。
pre[i] 表示移除从 s[0] 到 s[i] 的所有违禁货物车厢所花费的最少时间。
  - 当 s[i]=0 时，无需移除车厢，则有 pre[i]=pre[i−1]；
  - 当 s[i]=1 时，可以单独移除第 i 节车厢，也可以移除前 i 个车厢，二者取最小值，即 pre[i]=min(pre[i−1]+2,i+1)。
suf[i] 表示移除从 s[i] 到 s[n−1] 的所有违禁货物车厢所花费的最少时间。
  - 当 s[i]=0 时，无需移除车厢，则有 suf[i]=suf[i+1]；
  - 当 s[i]=1 时，无需移除车厢，则有 suf[i]=min(suf[i+1]+2,n-i)。
时间复杂度 O(n)。
 */