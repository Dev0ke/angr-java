import java.util.Arrays;

public class Solution2222 {
    public long numberOfWays(String s) {
        int n = s.length();
        int[] L = new int[n];
        int[] R = new int[n];

        // 左到右
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            cnt[d]++;
            L[i] = cnt[d ^ 1];
        }
        // 右到左
        Arrays.fill(cnt, 0);
        for (int i = n - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            cnt[d]++;
            R[i] = cnt[d ^ 1];
        }

        // 统计乘积和
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) L[i] * R[i];
        }
        return ans;
    }
}
/*
2222. 选择建筑的方案数
https://leetcode.cn/problems/number-of-ways-to-select-buildings/

第 75 场双周赛 T3。

给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
- s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
- s[i] = '1' 表示第 i 栋建筑是一间餐厅。
作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
- 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
请你返回可以选择 3 栋建筑的 有效方案数 。
提示：
3 <= s.length <= 10^5
s[i] 要么是 '0' ，要么是 '1' 。

只有两种可能 "010" 和 "101"
分别统计每个 1 左侧 0 的数量和右侧 0 的数量，乘积即为以该 1 为中心的方案数。
分别统计每个 0 左侧 1 的数量和右侧 1 的数量，乘积即为以该 0 为中心的方案数。
时间复杂度 O(n)
相似题目: 2063. 所有子字符串中的元音
https://leetcode.cn/problems/vowels-of-all-substrings/
 */