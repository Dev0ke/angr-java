public class Solution2562 {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long res = 0L;
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (i < j) {
                res += Integer.parseInt("" + nums[i] + nums[j]);
            } else {
                res += nums[i];
            }
        }
        return res;
    }
}
/*
2562. 找出数组的串联值
https://leetcode.cn/problems/find-the-array-concatenation-value/

第 332 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。
现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。
- 例如，15 和 49 的串联是 1549 。
nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：
- 如果 nums 中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，然后从 nums 中删除第一个和最后一个元素。
- 如果仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
返回执行完所有操作后 nums 的串联值。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^4

双指针模拟。
 */