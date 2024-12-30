public class Solution1526 {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            res += Math.max(target[i] - target[i - 1], 0);
        }
        return res;
    }
}
/*
1526. 形成目标数组的子数组最少增加次数
https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
- 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。
答案保证在 32 位有符号整数以内。
提示：
1 <= target.length <= 10^5
1 <= target[i] <= 10^5

差分思想。求出数组 target 中相邻两元素的差值，保留大于 0 的部分，累加即为答案。
证明见官方题解 https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solution/xing-cheng-mu-biao-shu-zu-de-zi-shu-zu-zui-shao-ze/
一种近似解法：找出每个山峰，累计每个山峰减去前一个山谷的高度，再加上第一个山谷的高度。
相似题目: 3229. 使数组等于目标数组所需的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-array-equal-to-target/description/
 */