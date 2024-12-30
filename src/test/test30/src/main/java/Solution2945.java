import java.util.ArrayList;
import java.util.List;

public class Solution2945 {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        int[] f = new int[n + 1];
        long[] last = new long[n + 1];
        List<Integer> q = new ArrayList<>();
        q.add(0);
        for (int i = 1; i <= n; i++) {
            // 1、在转移前，去掉队首无用数据
            while (q.size() > 1 && ps[q.get(1)] + last[q.get(1)] <= ps[i]) {
                q.remove(0);
            }
            // 2、转移
            f[i] = f[q.get(0)] + 1;
            last[i] = ps[i] - ps[q.get(0)];
            // 3、把 f 入队尾，同时去掉队尾的无用数据
            while (!q.isEmpty() && ps[q.get(q.size() - 1)] + last[q.get(q.size() - 1)] >= ps[i] + last[i]) {
                q.remove(q.size() - 1);
            }
            q.add(i);
        }
        return f[n];
    }
}
/*
2945. 找到最大非递减数组的长度
https://leetcode.cn/problems/find-maximum-non-decreasing-array-length/description/

第 118 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums 。
你可以执行任意次操作。每次操作中，你需要选择一个 子数组 ，并将这个子数组用它所包含元素的 和 替换。
比方说，给定数组是 [1,3,5,6] ，你可以选择子数组 [3,5] ，用子数组的和 8 替换掉子数组，然后数组会变为 [1,8,6] 。
请你返回执行任意次操作以后，可以得到的 最长非递减 数组的长度。
子数组 指的是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

贪心是错误解法。
划分型 DP
DFS 最后一段从 i 到 n-1
0 ~ i-1
从 i-1 转移过来
---
f[i] 表示操作下标 0~i 的最长长度
last[i] 表示这个操作后，最后一个数字的大小
在 f[i] 尽量大的前提下，last[i] 越小越好
---
f[i] = f[j] + 1  把 j+1 到 i 的这一段合并成一个数
s[i] - s[j] >= last[j]
s[i] >= s[j] + last[j]
权值线段树
---
对于两个下标 j < k
如果 s[j] + last[j] <= s[k] + last[k] <= s[i] <= s[i+1] <= s[i+2]...
由于转移来源 j 越大，那么 f[j] 也越大（因为 f 数组是递增的）
这个时候，还需要保留 j 这个数据吗？
不需要 => 可以用单调队列优化
1、在转移前，去掉队首无用数据
s[j] + last[j] <= s[k] + last[k] <= ... s[i]
队首的第二个下标满足 s[idx] + last[idx] <= s[i]
就可以把队首去掉
2、转移
f[i] = f[q[0]] + 1
last[i] = s[i] - s[q[0]]
3、把 f 入队尾，同时去掉队尾的无用数据
... s[j] + last[j] <= s[k] + last[k]
因为 Java 的 Deque 不能通过下标索引，因此要用 List
相似题目: 2366. 将数组排序的最少替换次数
https://leetcode.cn/problems/minimum-replacements-to-sort-the-array/
2944. 购买水果需要的最少金币数
https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/description/
 */