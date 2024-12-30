import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k)) {
                res.add(num - k);
            }
            set.add(num);
        }
        return res.size();
    }
}
/*
532. 数组中的 k-diff 数对
https://leetcode.cn/problems/k-diff-pairs-in-an-array/description/

给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
- 0 <= i, j < nums.length
- i != j
- |nums[i] - nums[j]| == k
注意，|val| 表示 val 的绝对值。
提示：
1 <= nums.length <= 10^4
-10^7 <= nums[i] <= 10^7
0 <= k <= 10^7

排序 + 哈希表。其实不排序也可以。排序后判断单侧即可。
时间复杂度 O(nlogn)
 */