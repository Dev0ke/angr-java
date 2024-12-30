import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < len - 2; i++) {
            // 剪枝
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // 双指针
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resList.add(List.of(nums[i], nums[left], nums[right]));

                    // 移动到下一个不相等的元素
                    int l0 = left + 1;
                    while (l0 < right && nums[l0] == nums[left]) {
                        l0++;
                    }
                    left = l0;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resList;
    }
}
/*
15. 三数之和
https://leetcode.cn/problems/3sum/

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
提示：
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

两数之和 升级版。先选出一个数，余下两个数用双指针方法解决
时间复杂度 O(n^2)
其中排序时间复杂度 O(nlogn)
相似题目: 16. 最接近的三数之和
https://leetcode.cn/problems/3sum-closest/
167. 两数之和 II - 输入有序数组
https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */