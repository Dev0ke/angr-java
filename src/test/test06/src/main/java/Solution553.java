public class Solution553 {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder ans = new StringBuilder();
        ans.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < n; i++) {
            ans.append("/").append(nums[i]);
        }
        ans.append(")");
        return ans.toString();
    }
}
/*
553. 最优除法
https://leetcode.cn/problems/optimal-division/description/

给定一正整数数组 nums，nums 中的相邻整数将进行浮点除法。例如， [2,3,4] -> 2 / 3 / 4 。
- 例如，nums = [2,3,4]，我们将求表达式的值 "2/3/4"。
但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，以便计算后的表达式的值为最大值。
以字符串格式返回具有最大值的对应表达式。
注意：你的表达式不应该包含多余的括号。
说明:
1 <= nums.length <= 10
2 <= nums[i] <= 1000
对于给定的输入只有一种最优除法。

脑筋急转弯。
当 nums[0] / (nums[1]*nums[2]*...*nums[n-1]) 时，数组构成的表达式计算结果最大。
时间复杂度 o(n)
 */