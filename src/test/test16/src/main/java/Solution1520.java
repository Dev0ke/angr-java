import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1520 {
    // 类似 452、646、1353
    public List<String> maxNumOfSubstrings(String s) {
        int[][] ranges = new int[26][2];
        for (char c = 'a'; c <= 'z'; c++) {
            int l = s.indexOf(c);
            int r = s.lastIndexOf(c);
            ranges[c - 'a'] = new int[]{l, r};
        }
        List<int[]> seg = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int[] pi = ranges[i];
            if (pi[0] == -1) continue;
            for (int j = pi[0]; j <= pi[1]; j++) {
                int[] pj = ranges[s.charAt(j) - 'a'];
                if (pi[0] <= pj[0] && pj[1] <= pi[1]) continue;
                pi[0] = Math.min(pi[0], pj[0]);
                pi[1] = Math.max(pi[1], pj[1]);
                j = pi[0];
            }
            seg.add(pi);
        }

        // 按右端点排序
        seg.sort(Comparator.comparingInt(o -> o[1]));
        List<String> ans = new ArrayList<>();
        int pre_r = -1;
        for (int[] p : seg) {
            int l = p[0], r = p[1];
            if (l >= pre_r) {
                ans.add(s.substring(p[0], p[1] + 1));
                pre_r = r;
            }
        }
        return ans;
    }
}
/*
1520. 最多的不重叠子字符串
https://leetcode.cn/problems/maximum-number-of-non-overlapping-substrings/description/

给你一个只包含小写字母的字符串 s ，你需要找到 s 中最多数目的非空子字符串，满足如下条件：
1.这些字符串之间互不重叠，也就是说对于任意两个子字符串 s[i..j] 和 s[x..y] ，要么 j < x 要么 i > y 。
2.如果一个子字符串包含字符 char ，那么 s 中所有 char 字符都应该在这个子字符串中。
请你找到满足上述条件的最多子字符串数目。如果有多个解法有相同的子字符串数目，请返回这些子字符串总长度最小的一个解。可以证明最小总长度解是唯一的。
请注意，你可以以 任意 顺序返回最优解的子字符串。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

先预处理出不重叠的区间。再贪心选择。
时间复杂度 O(26n + 26log26)。
 */