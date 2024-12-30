public class Solution440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    public int getSteps(int cur, long n) {
        int steps = 0;
        long first = cur, last = cur;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
/*
440. 字典序的第K小数字
https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/

给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
提示:
1 <= k <= n <= 10^9

字典树
[字节跳动最常考题之一]本题史上最完整具体的手摸手解答，时间效率超越100%用户 https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/
时间复杂度 O(logn·logn)
 */