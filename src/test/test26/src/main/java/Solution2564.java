import java.util.HashMap;
import java.util.Map;

public class Solution2564 {
    private static final int[] NOT_FOUND = {-1, -1};

    public int[][] substringXorQueries(String s, int[][] queries) {
        int len = s.length();

        // 预处理
        Map<String, int[]> memoMap = new HashMap<>();
        for (int k = 0; k <= 30; k++) {
            for (int i = 0; i + k < len; i++) {
                int j = i + k;
                // [i, j]
                String x = s.substring(i, j + 1);
                memoMap.putIfAbsent(x, new int[]{i, j});
            }
        }

        int q = queries.length;
        int[][] res = new int[q][2];
        for (int i = 0; i < q; i++) {
            // val ^ firsti == secondi
            // a^b^b = a
            int val = queries[i][0] ^ queries[i][1];
            res[i] = memoMap.getOrDefault(Integer.toBinaryString(val), NOT_FOUND);
        }
        return res;
    }
}
/*
2564. 子字符串异或查询
https://leetcode.cn/problems/substring-xor-queries/

第 332 场周赛 T3。

给你一个 二进制字符串 s 和一个整数数组 queries ，其中 queries[i] = [firsti, secondi] 。
对于第 i 个查询，找到 s 的 最短子字符串 ，它对应的 十进制值 val 与 firsti 按位异或 得到 secondi ，换言之，val ^ firsti == secondi 。
第 i 个查询的答案是子字符串 [lefti, righti] 的两个端点（下标从 0 开始），如果不存在这样的子字符串，则答案为 [-1, -1] 。如果有多个答案，请你选择 lefti 最小的一个。
请你返回一个数组 ans ，其中 ans[i] = [lefti, righti] 是第 i 个查询的答案。
子字符串 是一个字符串中一段连续非空的字符序列。
提示：
1 <= s.length <= 10^4
s[i] 要么是 '0' ，要么是 '1' 。
1 <= queries.length <= 10^5
0 <= firsti, secondi <= 10^9

位运算知识 + 预处理
预处理枚举长度不超过 30 的子串。时间复杂度 O(30 * n)
查询时间可以近似看成 O(1)
 */