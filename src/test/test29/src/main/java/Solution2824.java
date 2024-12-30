import java.util.List;

public class Solution2824 {
    // O(n^2)
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // O(n)
    public int countPairs2(List<Integer> nums, int target) {
        int n = nums.size();
        nums.sort(null);

        int ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
/*
2824. 统计和小于目标的下标对数目
https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/

第 111 场双周赛 T1。

给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
提示：
1 <= nums.length == n <= 50
-50 <= nums[i], target <= 50

暴力 / 双指针
 */