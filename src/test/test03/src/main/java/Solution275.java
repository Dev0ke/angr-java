public class Solution275 {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int left = 1;
        int right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(citations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // h 指数为 mid 时，是否成立 TTTFFF
    private boolean checkMid(int[] citations, int mid) {
        int n = citations.length;
        return citations[n - mid] >= mid;
    }
}
/*
275. H 指数 II
https://leetcode.cn/problems/h-index-ii/

给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
请你设计并实现对数时间复杂度的算法解决此问题。
提示：
n == citations.length
1 <= n <= 10^5
0 <= citations[i] <= 1000
citations 按 升序排列

二分
 */