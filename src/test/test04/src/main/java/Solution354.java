import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        // LIS
        List<Integer> a = new ArrayList<>();
        for (int[] e : envelopes) {
            int x = e[1];
            int j = lowerBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
        }
        return a.size();
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
354. 俄罗斯套娃信封问题
https://leetcode.cn/problems/russian-doll-envelopes/

给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
注意：不允许旋转信封。
提示：
1 <= envelopes.length <= 10^5
envelopes[i].length == 2
1 <= wi, hi <= 10^5

二维偏序问题。
可以按宽度升序排序，高度降序排序，再按高度求 LIS 长度。
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */