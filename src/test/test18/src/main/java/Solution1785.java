public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int v : nums) sum += v;
        return (int) ((Math.abs(sum - goal) + limit - 1) / limit);
    }
}
/*
1785. 构成特定和需要添加的最少元素
https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/description/

给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
提示：
1 <= nums.length <= 10^5
1 <= limit <= 10^6
-limit <= nums[i] <= limit
-10^9 <= goal <= 10^9

数学。向上取整。
时间复杂度 O(n)。
 */