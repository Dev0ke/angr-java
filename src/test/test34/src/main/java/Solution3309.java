import java.util.Arrays;

public class Solution3309 {
    public int maxGoodNumber(int[] nums) {
        String[] a = {Integer.toBinaryString(nums[0]), Integer.toBinaryString(nums[1]), Integer.toBinaryString(nums[2])};
        Arrays.sort(a, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String res = String.join("", a);
        return Integer.parseInt(res, 2);
    }
}
/*
3309. 连接二进制表示可形成的最大数值
https://leetcode.cn/problems/maximum-possible-number-by-binary-concatenation/description/

第 418 场周赛 T1。

给你一个长度为 3 的整数数组 nums。
现以某种顺序 连接 数组 nums 中所有元素的 二进制表示 ，请你返回可以由这种方法形成的 最大 数值。
注意 任何数字的二进制表示 不含 前导零。
提示:
nums.length == 3
1 <= nums[i] <= 127

中国时间：2024-10-06 10:30
相似题目: bytedance-010. 数组组成最大数
https://leetcode.cn/problems/9nsGSS/
 */