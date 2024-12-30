import java.util.Arrays;
import java.util.Comparator;

public class Solution962 {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> nums[o]));

        int max = 0;
        int min = n;
        for (int id : ids) {
            max = Math.max(max, id - min);
            min = Math.min(min, id);
        }
        return max;
    }
}
/*
962. 最大宽度坡
https://leetcode.cn/problems/maximum-width-ramp/

给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
找出 A 中的坡的最大宽度，如果不存在，返回 0 。
提示：
2 <= A.length <= 50000
0 <= A[i] <= 50000

排序
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */
