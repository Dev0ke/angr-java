import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2975 {
    private static final int MOD = (int) (1e9 + 7);

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hSet = getDiffs(m, hFences);
        Set<Integer> vSet = getDiffs(n, vFences);
        int maxLen = 0;
        for (Integer x : hSet) {
            if (vSet.contains(x)) {
                maxLen = Math.max(maxLen, x);
            }
        }
        long ans = maxLen == 0 ? -1 : (long) maxLen * maxLen % MOD;
        return (int) ans;
    }

    private Set<Integer> getDiffs(int len, int[] fences) {
        int n = fences.length;
        int[] a = new int[n + 2];
        System.arraycopy(fences, 0, a, 0, n);
        a[n] = 1;
        a[n + 1] = len;
        Arrays.sort(a);

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                res.add(a[j] - a[i]);
            }
        }
        return res;
    }
}
/*
2975. 移除栅栏得到的正方形田地的最大面积
https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field/description/

第 377 场周赛 T2。

有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。
水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。
返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。
由于答案可能很大，所以请返回结果对 10^9 + 7 取余 后的值。
注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。
提示：
3 <= m, n <= 10^9
1 <= hFences.length, vFences.length <= 600
1 < hFences[i] < m
1 < vFences[i] < n
hFences 和 vFences 中的元素是唯一的。

哈希表
时间复杂度 O(h^2 + v^2)。
 */