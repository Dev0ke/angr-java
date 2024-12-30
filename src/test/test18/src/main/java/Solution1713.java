import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1713 {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        // 预处理下标
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.put(target[i], i);
        }

        List<Integer> a = new ArrayList<>();
        for (int ai : arr) {
            if (posMap.containsKey(ai)) {
                Integer x = posMap.get(ai);
                int j = lowerBound(a, x);
                if (j == a.size()) a.add(x);
                else a.set(j, x);
            }
        }
        return n - a.size();
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
1713. 得到子序列的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/

给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。
比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
提示：
1 <= target.length, arr.length <= 10^5
1 <= target[i], arr[i] <= 10^9
target 不包含任何重复元素。

最少添加的元素个数为 n 减去两数组的最长公共子序列的长度，但求 LCS 时间复杂度为 O(mn) 本题会 TLE，需要转变思路。
转化成 LIS 问题，时间复杂度 O(n + mlogm)
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */