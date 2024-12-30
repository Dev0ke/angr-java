import java.util.ArrayList;
import java.util.List;

public class SolutionP1940 {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int n = arrays.length;
        int[] cnt = new int[105];
        for (int[] arr : arrays) {
            for (int x : arr) {
                cnt[x]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 105; i++) {
            if (cnt[i] == n) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
$1940. 排序数组之间的最长公共子序列
https://leetcode.cn/problems/longest-common-subsequence-between-sorted-arrays/description/

给定一个由整数数组组成的数组arrays，其中arrays[i]是严格递增排序的，返回一个表示所有数组之间的最长公共子序列的整数数组。
子序列是从另一个序列派生出来的序列，删除一些元素或不删除任何元素，而不改变其余元素的顺序。
限制条件:
2 <= arrays.length <= 100
1 <= arrays[i].length <= 100
1 <= arrays[i][j] <= 100
arrays[i] 是严格递增排序.

因为是严格递增，直接计数即可。
时间复杂度 O(mn)。其中 m 是数组 arrays 中的数组数目，n 是数组 arrays 中的最长数组的长度
 */