import java.util.HashSet;
import java.util.Set;

public class Solution2763 {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 不平衡数字之和 = j-i-balance
            int balance = 0;
            Set<Integer> set = new HashSet<>();
            set.add(nums[i]);
            for (int j = i + 1; j < n; j++) {
                int x = nums[j];
                if (set.contains(x)) {
                    balance++;
                } else {
                    if (set.contains(x - 1)) balance++;
                    if (set.contains(x + 1)) balance++;
                }
                set.add(x);

                ans += j - i - balance;
            }
        }
        return ans;
    }
}
/*
2763. 所有子数组中不平衡数字之和
https://leetcode.cn/problems/sum-of-imbalance-numbers-of-all-subarrays/

第 352 场周赛 T4。

一个长度为 n 下标从 0 开始的整数数组 arr 的 不平衡数字 定义为，在 sarr = sorted(arr) 数组中，满足以下条件的下标数目：
- 0 <= i < n - 1 ，和
- sarr[i+1] - sarr[i] > 1
这里，sorted(arr) 表示将数组 arr 排序后得到的数组。
给你一个下标从 0 开始的整数数组 nums ，请你返回它所有 子数组 的 不平衡数字 之和。
子数组指的是一个数组中连续一段 非空 的元素序列。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= nums.length

时间复杂度 O(n^2)
另有 O(n) 解法
 */