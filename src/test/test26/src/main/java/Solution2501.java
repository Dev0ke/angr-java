import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2501 {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Set<Integer> visited = new HashSet<>();
        int max = 1;
        for (int num : nums) {
            int x = num;
            int cnt = 1;
            if (visited.contains(x)) {
                continue;
            }
            while (set.contains(x * x)) {
                visited.add(x);
                x = x * x;
                cnt++;
                max = Math.max(max, cnt);
            }
        }
        return max == 1 ? -1 : max;
    }
}
/*
2501. 数组中最长的方波
https://leetcode.cn/problems/longest-square-streak-in-an-array/

第 323 场周赛 T2。

给你一个整数数组 nums 。如果 nums 的子序列满足下述条件，则认为该子序列是一个 方波 ：
- 子序列的长度至少为 2 ，并且
- 将子序列从小到大排序 之后 ，除第一个元素外，每个元素都是前一个元素的 平方 。
返回 nums 中 最长方波 的长度，如果不存在 方波 则返回 -1 。
子序列 也是一个数组，可以由另一个数组删除一些或不删除元素且不改变剩余元素的顺序得到。
提示：
2 <= nums.length <= 10^5
2 <= nums[i] <= 10^5

HashSet 枚举
 */