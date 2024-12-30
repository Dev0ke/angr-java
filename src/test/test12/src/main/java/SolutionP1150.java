public class SolutionP1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int cnt = 0;
        for (int num : nums) {
            if (num == target) {
                cnt++;
            }
        }
        return cnt > len / 2;
    }
}
/*
$1150. 检查一个数是否在数组中占绝大多数
https://leetcode.cn/problems/check-if-a-number-is-majority-element-in-a-sorted-array/

第 6 场双周赛 T1。

给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= target <= 10^9

模拟。
 */