public class SolutionP280 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;

        boolean less = true;
        for (int i = 0; i + 1 < len; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
/*
$280. 摆动排序
https://leetcode.cn/problems/wiggle-sort/

给你一个的整数数组 nums, 将该数组重新排序后使 nums[0] <= nums[1] >= nums[2] <= nums[3]... 
输入数组总是有一个有效的答案。
提示：
1 <= nums.length <= 5 * 10^4
0 <= nums[i] <= 10^4
输入的 nums 保证至少有一个答案。
进阶：你能在 O(n) 时间复杂度下解决这个问题吗？

constructive algorithms 构造题
一次遍历。
时间复杂度 O(n)
思考如何 UT 如何编写
 */