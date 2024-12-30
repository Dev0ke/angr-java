public class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int ai = (nums[i - 1] + nums[i]) % 2 == 1 ? 0 : 1;
            ps[i] = ps[i - 1] + ai;
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int from = queries[i][0], to = queries[i][1];
            ans[i] = ps[to] - ps[from] == 0;
        }
        return ans;
    }
}
/*
3152. 特殊数组 II
https://leetcode.cn/problems/special-array-ii/description/

第 398 场周赛 T2。

如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助周洋哥检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] <= nums.length - 1

前缀和。
a[i] = 0, nums[i]%2 != nums[i+1]%2
a[i] = 1, nums[i]%2 == nums[i+1]%2
那么 a 的从 from 到 to−1 的子数组和等于 0，就说明询问的子数组是特殊数组。
注意边界分析，WA 麻了。。
时间复杂度 O(n+q)
 */