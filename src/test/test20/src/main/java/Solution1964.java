import java.util.ArrayList;
import java.util.List;

public class Solution1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] f = new int[n];
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = obstacles[i];
            int j = upperBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
            f[i] = j + 1;
        }
        return f;
    }

    private int upperBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/

第 253 场周赛 T4。

你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
- 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
- 在这条路线中，必须包含第 i 个障碍。
- 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
- 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
提示：
n == obstacles.length
1 <= n <= 10^5
1 <= obstacles[i] <= 10^7

容易误想到单调栈，实际上本题单调栈不可行，单调栈求出的长度并不是最优的，如：
input:    [5,1,5,5,1,3,4,5,1,4]
actual:   [1,1,2,3,2,3,4,5,3,4]
expected: [1,1,2,3,2,3,4,5,3,5]
LIS。
时间复杂度需为 O(nlogn)。注意本题是 upperBound，第 300 题是 lowerBound。
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */