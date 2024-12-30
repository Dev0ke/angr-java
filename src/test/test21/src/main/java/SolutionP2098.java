import java.util.Arrays;

public class SolutionP2098 {
    public long largestEvenSum(int[] nums, int k) {
        reverseSort(nums);
        long sum = 0;
        int min_odd = Integer.MAX_VALUE;
        int min_even = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (nums[i] % 2 == 0) min_even = nums[i];
            else min_odd = nums[i];
        }
        if (sum % 2 == 0) return sum;

        int max_odd = Integer.MIN_VALUE;
        int max_even = Integer.MIN_VALUE;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i] > max_even) max_even = nums[i];
            } else {
                if (nums[i] > max_odd) max_odd = nums[i];
            }
        }
        long ans = Math.max(sum - min_odd + max_even, sum - min_even + max_odd);
        return ans >= 0 ? ans : -1;
    }

    private void reverseSort(int[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
$2098. 长度为 K 的最大偶数和子序列
https://leetcode.cn/problems/subsequence-of-size-k-with-the-largest-even-sum/description/

给你一个整数数组 nums 和一个整数 k 。找出 nums 长度为 k 的所有子序列中的 最大偶数和 。
返回此总和，如果此总和不存在，则返回 -1。
子序列 是一个数组，可以通过删除一些元素或不删除任何元素而从另一个数组派生，而不改变其余元素的顺序。
Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
1 <= k <= nums.length

贪心。先排序，取最大 k 个数，若为偶数，即为答案。
否则为奇数
case1：减去最小奇数，加上外围最大偶数
case2：减去最小偶数，加上外围最大奇数
时间复杂度 O(nlogn)。
 */