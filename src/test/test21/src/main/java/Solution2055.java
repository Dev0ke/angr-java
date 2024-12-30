import java.util.ArrayList;
import java.util.List;

public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        // 记录每个 '|' 下标
        List<Integer> candleIdxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candleIdxList.add(i);
            }
        }

        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int qLeft = queries[i][0], qRight = queries[i][1];
            // 二分找左右 '|' 边界
            int leftIdx = getNearestRightIdx(candleIdxList, qLeft);
            int rightIdx = getNearestLeftIdx(candleIdxList, qRight);
            if (leftIdx < rightIdx) {
                // 实际下标
                int l = candleIdxList.get(leftIdx);
                int r = candleIdxList.get(rightIdx);
                // [l, r] 区间长度
                int allCnt = r - l + 1;
                // [l, r] 区间 '|' 的数量
                int candleCnt = rightIdx - leftIdx + 1;
                res[i] = allCnt - candleCnt;
            }
        }
        return res;
    }

    // 下标 x 及其右侧的最近蜡烛 在 candleIdxList 中的下标
    private int getNearestRightIdx(List<Integer> candleIdxList, int x) {
        int left = 0;
        int right = candleIdxList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (candleIdxList.get(mid) >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 下标 x 及其左侧的最近蜡烛 在 candleIdxList 中的下标
    private int getNearestLeftIdx(List<Integer> candleIdxList, int x) {
        int left = 0;
        int right = candleIdxList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (candleIdxList.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
/*
2055. 蜡烛之间的盘子
https://leetcode.cn/problems/plates-between-candles/

第 64 场双周赛 T3。

给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
- 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，
子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
提示：
3 <= s.length <= 10^5
s 只包含字符 '*' 和 '|' 。
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= lefti <= righti < s.length

预处理记录每个 '|' 下标。对于每组查询，二分找左右 '|' 边界，计算数量。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */