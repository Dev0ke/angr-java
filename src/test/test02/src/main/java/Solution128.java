import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int cnt = 0;
                while (hashSet.contains(num + cnt)) {
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
/*
128. 最长连续序列
https://leetcode.cn/problems/longest-consecutive-sequence/

给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

很巧妙的一道题，使用 HashSet 时间复杂度 O(1) 内判断 num 是否存在
通过判断 num-1 是否存在，如果存在，直接剪枝，因为此刻最长长度必然不会从 num 开始
时间复杂度 O(n)
 */
