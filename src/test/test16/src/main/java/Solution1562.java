public class Solution1562 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) return n;

        int ans = -1;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; i++) {
            int j = arr[i];
            int spanL = f[j - 1];
            int spanR = f[j + 1];
            if (spanL == m || spanR == m) {
                ans = i;
            }
            // 由于合并的时候只会访问区间端点，所以合并区间的时候修改端点区间长度即可。
            f[j - spanL] = spanL + spanR + 1;
            f[j + spanR] = spanL + spanR + 1;
        }
        return ans;
    }
}
/*
1562. 查找大小为 M 的最新分组
https://leetcode.cn/problems/find-latest-group-of-size-m/

给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
返回存在长度 恰好 为 m 的 一组 1 的最后步骤。如果不存在这样的步骤，请返回 -1 。
提示：
n == arr.length
1 <= n <= 10^5
1 <= arr[i] <= n
arr 中的所有整数 互不相同
1 <= m <= arr.length

好神奇的做法。。
正向思维 vs 逆向思维
https://leetcode.cn/problems/find-latest-group-of-size-m/solution/zheng-xiang-si-wei-by-sui-xin-yuan-oaiv/
时间复杂度 O(n)
相似题目: 803. 打砖块
https://leetcode.cn/problems/bricks-falling-when-hit/
 */