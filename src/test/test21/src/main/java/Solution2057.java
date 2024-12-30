public class Solution2057 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
/*
2057. 值相等的最小索引
https://leetcode.cn/problems/smallest-index-with-equal-value/

第 265 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1 。
x mod y 表示 x 除以 y 的 余数 。

根据题意模拟即可。
 */