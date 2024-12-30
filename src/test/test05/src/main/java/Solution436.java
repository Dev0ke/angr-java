import java.util.Arrays;
import java.util.Comparator;

public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] rightIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            rightIdx[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(rightIdx, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            int j = lowerBound(rightIdx, intervals[i][1]);
            if (j < n) {
                ans[i] = rightIdx[j][1];
            }
        }
        return ans;
    }

    private int lowerBound(int[][] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m][0] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
436. 寻找右区间
https://leetcode.cn/problems/find-right-interval/

给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
提示：
1 <= intervals.length <= 2 * 10^4
intervals[i].length == 2
-10^6 <= starti <= endi <= 10^6
每个间隔的起点都 不相同

排序 + 二分查找
时间复杂度 O(nlogn)
 */