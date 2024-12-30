public class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[105];
        int ans = 0;
        for (int v : nums) {
            ans += cnt[v];
            cnt[v]++;
        }
        return ans;
    }
}
/*
1512. 好数对的数目
https://leetcode.cn/problems/number-of-good-pairs/description/

给你一个整数数组 nums 。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
返回好数对的数目。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

前缀和。
时间复杂度 O(n)。
 */