public class SolutionP683 {
    private int ans;
    private int left;
    private int right;

    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[bulbs[i] - 1] = i + 1;
        }

        ans = Integer.MAX_VALUE;
        left = 0;
        right = k + 1;
        extracted(k, n, days);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void extracted(int k, int n, int[] days) {
        while (right < n) {
            for (int i = left + 1; i < right; i++) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    extracted(k, n, days);
                    return;
                }
            }
            ans = Math.min(ans, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }
    }

    public int kEmptySlots2(int[] bulbs, int k) {
        int[] days = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            days[bulbs[i] - 1] = i + 1;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0, right = k + 1;

//        search:
        while (right < days.length) {
            boolean flag = false;
            for (int i = left + 1; i < right; ++i) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    flag = true;
                    break;
//                    continue search;
                }
            }
            if (flag) {
                continue;
            }

            ans = Math.min(ans, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
/*
$683. K 个关闭的灯泡
https://leetcode.cn/problems/k-empty-slots/

n 个灯泡排成一行，编号从 1 到 n 。最初，所有灯泡都关闭。每天 只打开一个 灯泡，直到 n 天后所有灯泡都打开。
给你一个长度为 n 的灯泡数组 blubs ，其中 bulls[i] = x 意味着在第 (i+1) 天，我们会把在位置 x 的灯泡打开，其中 i 从 0 开始，x 从 1 开始。
给你一个整数 k ，请返回恰好有两个打开的灯泡，且它们中间 正好 有 k 个 全部关闭的 灯泡的 最小的天数 。如果不存在这种情况，返回 -1 。
提示：
n == bulbs.length
1 <= n <= 2 * 10^4
1 <= bulbs[i] <= n
bulbs 是一个由从 1 到 n 的数字构成的排列
0 <= k <= 2 * 10^4

滑动窗口
java continue label 参考 https://leetcode.cn/problems/k-empty-slots/solution/k-ge-kong-hua-pen-by-leetcode/
 */