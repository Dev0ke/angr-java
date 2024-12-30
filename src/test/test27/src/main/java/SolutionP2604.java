import java.util.Arrays;

public class SolutionP2604 {
    private int[] hens, grains;
    private int n, m;

    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);
        this.hens = hens;
        this.grains = grains;
        n = hens.length;
        m = grains.length;

        int left = 0;
        int right = hens[n - 1] + grains[m - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int time) {
        int i = 0, j = 0;
        while (i < n && j < m) {
            int left = hens[i], right = hens[i];
            while (j < m) {
                left = Math.min(left, grains[j]);
                right = Math.max(right, grains[j]);
                if (Math.min(hens[i] - left, right - hens[i]) + right - left > time) break;
                j++;
            }
            i++;
        }
        return j == m;
    }
}
/*
$2604. 吃掉所有谷子的最短时间
https://leetcode.cn/problems/minimum-time-to-eat-all-grains/description/

一条线上有 n 只母鸡和 m 颗谷子。给定两个整数数组 hens 和 grains ，它们的大小分别为 n 和 m ，表示母鸡和谷子的初始位置。
如果一只母鸡和一颗谷子在同一个位置，那么这只母鸡可以吃掉这颗谷子。吃掉一颗谷子的时间可以忽略不计。一只母鸡也可以吃掉多颗谷子。
在 1 秒钟内，一只母鸡可以向左或向右移动 1 个单位。母鸡可以同时且独立地移动。
如果母鸡行动得当，返回吃掉所有谷子的 最短 时间。
提示：
1 <= hens.length, grains.length <= 2*10^4
0 <= hens[i], grains[j] <= 10^9

二分答案。
时间复杂度 O(nlogn + mlogm + (m+n)logh)。
 */