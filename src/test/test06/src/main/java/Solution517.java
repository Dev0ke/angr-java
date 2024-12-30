import java.util.Arrays;

public class Solution517 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int tot = Arrays.stream(machines).sum();
        if (tot % n != 0) return -1;

        int avg = tot / n;
        int ans = 0;
        int sum = 0;
        for (int x : machines) {
            x -= avg;
            sum += x;
            ans = Math.max(ans, Math.max(Math.abs(sum), x));
        }
        return ans;
    }
}
/*
517. 超级洗衣机
https://leetcode.cn/problems/super-washing-machines/description/

假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
提示：
n == machines.length
1 <= n <= 10^4
0 <= machines[i] <= 10^5

贪心。
1、A 与 B 两组之间的衣服，最多需要 max_{i=0}^{n-1} |sum[i]|
2、某一台洗衣机内的衣服数量过多，需要向左右两侧移出衣服，最多需要 max_{i=0}^{n-1} (machines[i]-avg)
取二者最大值
时间复杂度 O(n)
 */