import java.util.List;

public class Solution3282 {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int mx = 0;
        for (int i = 0; i + 1 < nums.size(); i++) {
            mx = Math.max(mx, nums.get(i));
            ans += mx;
        }
        return ans;
    }
}
/*
3282. 到达数组末尾的最大得分
https://leetcode.cn/problems/reach-end-of-array-with-max-score/description/

第 414 场周赛 T3。

给你一个长度为 n 的整数数组 nums 。
你的目标是从下标 0 出发，到达下标 n - 1 处。每次你只能移动到 更大 的下标处。
从下标 i 跳到下标 j 的得分为 (j - i) * nums[i] 。
请你返回你到达最后一个下标处能得到的 最大总得分 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

贪心。
时间复杂度 O(n)。
 */