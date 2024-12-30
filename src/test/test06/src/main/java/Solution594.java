import java.util.HashMap;
import java.util.Map;

public class Solution594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : cntMap.keySet()) {
            if (cntMap.containsKey(key + 1)) {
                max = Math.max(max, cntMap.get(key) + cntMap.get(key + 1));
            }
        }
        return max;
    }
}
/*
594. 最长和谐子序列
https://leetcode.cn/problems/longest-harmonious-subsequence/

和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
提示：
1 <= nums.length <= 2 * 10^4
-10^9 <= nums[i] <= 10^9

HashMap 统计频次。贪心
 */