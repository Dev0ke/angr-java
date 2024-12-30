public class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        String numsStr = arr2Str(nums);

        int i = 0;
        for (int[] group : groups) {
            String s = arr2Str(group);
            int j = numsStr.indexOf(s, i);
            if (j > -1) {
                i = j + s.length();
            } else {
                return false;
            }
        }
        return true;
    }

    private String arr2Str(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(":").append(num);
        }
        return stringBuilder.toString();
    }
}
/*
1764. 通过连接另一个数组的子数组得到一个数组
https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/

给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
提示：
groups.length == n
1 <= n <= 10^3
1 <= groups[i].length, sum(groups[i].length) <= 10^3
1 <= nums.length <= 10^3
-10^7 <= groups[i][j], nums[k] <= 10^7

转为字符串，等价于按顺序找不相交子串。
 */