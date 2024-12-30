import java.util.Arrays;

public class Solution1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int step = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            step++;
            if (Arrays.equals(perm, target)) {
                return step;
            }
        }
    }
}
/*
1806. 还原排列的最少操作步数
https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
一步操作中，你将创建一个新数组 arr ，对于每个 i ：
- 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
- 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
然后将 arr 赋值给 perm 。
要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
提示：
2 <= n <= 1000
n 是一个偶数

模拟
 */