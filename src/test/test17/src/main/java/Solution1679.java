import java.util.HashMap;
import java.util.Map;

public class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            if (mp.getOrDefault(k - x, 0) > 0) {
                mp.merge(k - x, -1, Integer::sum);
                ans++;
            } else {
                mp.merge(x, 1, Integer::sum);
            }
        }
        return ans;
    }
}
/*
1679. K 和数对的最大数目
https://leetcode.cn/problems/max-number-of-k-sum-pairs/description/

给你一个整数数组 nums 和一个整数 k 。
每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
返回你可以对数组执行的最大操作数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9

两数之和。
时间复杂度 O(n)
 */