import java.util.HashSet;
import java.util.Set;

public class Solution3289 {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        int j = 0;
        for (int v : nums) {
            if (set.contains(v)) {
                ans[j++] = v;
            } else {
                set.add(v);
            }
        }
        return ans;
    }
}
/*
3289. 数字小镇中的捣蛋鬼
https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/description/

第 415 场周赛 T1。

数字小镇 Digitville 中，存在一个数字列表 nums，其中包含从 0 到 n - 1 的整数。每个数字本应 只出现一次，然而，有 两个 顽皮的数字额外多出现了一次，使得列表变得比正常情况下更长。
为了恢复 Digitville 的和平，作为小镇中的名侦探，请你找出这两个顽皮的数字。
返回一个长度为 2 的数组，包含这两个数字（顺序任意）。
提示：
2 <= n <= 100
nums.length == n + 2
0 <= nums[i] < n
输入保证 nums 中 恰好 包含两个重复的元素。

哈希表。
时间复杂度 O(n)。
 */