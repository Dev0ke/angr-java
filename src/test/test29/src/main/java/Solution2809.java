import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2809 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(nums2::get));

        int s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 += nums1.get(i);
            s2 += nums2.get(i);
        }
        int[] f = new int[n + 1];
        for (Integer id : ids) {
            for (int j = n; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + nums1.get(id) + nums2.get(id) * j);
            }
        }
        for (int t = 0; t <= n; t++) {
            if (s1 + s2 * t - f[t] <= x) {
                return t;
            }
        }
        return -1;
    }
}
/*
2809. 使数组和小于等于 x 的最少时间
https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/

第 110 场双周赛 T4。

给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[i] 的值都增加 nums2[i] 。操作 完成后 ，你可以进行如下操作：
- 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。
同时给你一个整数 x 。
请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。
提示：
1 <= nums1.length <= 10^3
1 <= nums1[i] <= 10^3
0 <= nums2[i] <= 10^3
nums1.length == nums2.length
0 <= x <= 10^6

排序不等式
1、答案最大是多少？ n
2、从小到大枚举答案
t=1 选一个当前最高的
t=2 比较相对值，比算绝对值要方便
按照 nums2 从小到大排序，nums2 越小的，越早操作
第 t 秒，不做任何操作，元素和是 s1 + s2 * t
从 nums1 中选一个长度为 t 的子序列，子序列的第一个数变成 nums1[i] + nums2[i]
第 j 个数变成 nums1[i] + j * nums2[i]
选或不选 dp
f[i+1][j] 前 i 个数中，选长为 j 的子序列，改变后的元数和的最大值
不选 f[i+1][j] = f[i][j]
选  f[i+1][j] = f[i][j-1] + nums1[i] + j * nums2[i]
 */