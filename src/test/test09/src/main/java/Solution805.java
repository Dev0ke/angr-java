import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution805 {
    public boolean splitArraySameAverage(int[] nums) {
        // meet in the middle（折半搜索）
        int n = nums.length;
        int a = n / 2;
        int b = n - a;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            // 减去 avg 且避免浮点数
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> left = new HashSet<>();
        for (int state = 1; state < (1 << a); state++) {
            int tot = 0;
            for (int k = 0; k < a; k++) {
                if (((state >> k) & 1) == 1) {
                    tot += nums[k];
                }
            }
            if (tot == 0) {
                return true;
            }
            left.add(tot);
        }

        // 左半部分全取了，右半部分就不能全取
        for (int state = 1; state < (1 << b) - 1; state++) {
            int tot = 0;
            for (int k = 0; k < b; k++) {
                if (((state >> k) & 1) == 1) {
                    tot += nums[a + k];
                }
            }
            if (tot == 0 || left.contains(-tot)) {
                return true;
            }
        }
        return false;
    }
}
/*
805. 数组的均值分割
https://leetcode.cn/problems/split-array-with-same-average/

给定你一个整数数组 nums
我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
如果可以完成则返回true ， 否则返回 false  。
注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。
提示:
1 <= nums.length <= 30
0 <= nums[i] <= 10^4

meet in the middle（折半搜索）
时间复杂度 O(n*2^(n/2)) 理论上界 30 * 2^15 = 983,040
相似题目: 1755. 最接近目标值的子序列和
https://leetcode.cn/problems/closest-subsequence-sum/
2035. 将数组分成两个数组并最小化数组和的差
https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */