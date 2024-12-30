import java.util.HashMap;
import java.util.Map;

public class Solution3134 {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long) n * (n + 1) / 2 + 1) / 2;

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] nums, long k, int mid) {
        int n = nums.length, l = 0, r = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int size = 0;
        long tot = 0;
        while (r < n) {
            if (cntMap.merge(nums[r], 1, Integer::sum) == 1) size++;
            while (size > mid) {
                if (cntMap.merge(nums[l], -1, Integer::sum) == 0) size--;
                l++;
            }
            tot += r - l + 1;
            if (tot >= k) return true;
            r++;
        }
        return false;
    }
}
/*
3134. 找出唯一性数组的中位数
https://leetcode.cn/problems/find-the-median-of-the-uniqueness-array/description/

第 395 场周赛 T4。

给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空子数组中不同元素的个数。
换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。
其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。
返回 nums 唯一性数组 的 中位数 。
注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

二分 + 滑动窗口。
时间复杂度 O(nlogn)。
rating 2482 (clist.by)
相似题目: 713. 乘积小于K的子数组
https://leetcode.cn/problems/subarray-product-less-than-k/
 */