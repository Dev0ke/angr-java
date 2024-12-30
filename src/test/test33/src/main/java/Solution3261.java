public class Solution3261 {
    public long[] countKConstraintSubstrings(String S, int k, int[][] queries) {
        int n = S.length();
        char[] s = S.toCharArray();
        int l = 0, r = 0;
        int[] cnt = new int[2];
//        int ans = 0;
        int[] Left = new int[n];
        long[] ps = new long[n + 1];
        while (r < n) {
            cnt[s[r] - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[l] - '0']--;
                l++;
            }
//            ans += r - l + 1;
            Left[r] = l;
            ps[r + 1] = ps[r] + (r - l + 1);

            r++;
        }

        int q = queries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int ql = queries[i][0], qr = queries[i][1];

            int j = bisect_left(Left, ql, ql, qr + 1);
            ans[i] = (ps[qr + 1] - ps[j]) + (j - ql + 1L) * (j - ql) / 2;
        }
        return ans;
    }

    private int bisect_left(int[] a, int key, int lo, int hi) {
        int l = lo, r = hi;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3261. 统计满足 K 约束的子字符串数量 II
https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-ii/description/

第 411 场周赛 T4。

给你一个 二进制 字符串 s 和一个整数 k。
另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
- 字符串中 0 的数量最多为 k。
- 字符串中 1 的数量最多为 k。
返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的 子字符串 的数量。
提示：
1 <= s.length <= 10^5
s[i] 是 '0' 或 '1'
1 <= k <= s.length
1 <= queries.length <= 10^5
queries[i] == [li, ri]
0 <= li <= ri < s.length
所有查询互不相同

滑动窗口+前缀和+二分查找。
时间复杂度 O(n + qlogn)。
rating 2675 (clist.by)
 */