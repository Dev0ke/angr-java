import java.util.Arrays;
import java.util.Comparator;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int cur = Integer.MIN_VALUE;
        int cnt = 0;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                cnt++;
            }
        }
        return cnt;
    }
}
/*
646. 最长数对链
https://leetcode.cn/problems/maximum-length-of-pair-chain/

给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
提示：
给出数对的个数在 [1, 1000] 范围内。

贪心。
时间复杂度 O(nlogn)
相似题目: 435. 无重叠区间
https://leetcode.cn/problems/non-overlapping-intervals/
 */