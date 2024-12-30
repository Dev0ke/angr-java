public class Solution2023 {
    public int numOfPairs(String[] nums, String target) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String pair0 = nums[i] + nums[j];
                if (pair0.equals(target)) {
                    res++;
                }
                String pair1 = nums[j] + nums[i];
                if (pair1.equals(target)) {
                    res++;
                }
            }
        }
        return res;
    }
}
/*
2023. 连接后等于目标字符串的字符串对
https://leetcode.cn/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

第 62 场双周赛 T2。

给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，
请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
提示：
2 <= nums.length <= 100
1 <= nums[i].length <= 100
2 <= target.length <= 100
nums[i] 和 target 只包含数字。
nums[i] 和 target 不含有任何前导 0 。

数据范围较小，双循环暴力。
 */