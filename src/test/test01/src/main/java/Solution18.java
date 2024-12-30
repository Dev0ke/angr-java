import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // -10^9 <= nums[i] <= 10^9 应使用 long 防止溢出
        long[] longNums = Arrays.stream(nums).asLongStream().toArray();

        List<List<Integer>> resList = new ArrayList<>();
        if (longNums == null || longNums.length < 4) {
            return resList;
        }
        Arrays.sort(nums);
        Arrays.sort(longNums);
        int len = longNums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && longNums[i] == longNums[i - 1]) {
                continue;
            }
            if (longNums[i] + longNums[i + 1] + longNums[i + 2] + longNums[i + 3] > target) {
                break;
            }
            if (longNums[i] + longNums[len - 3] + longNums[len - 2] + longNums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && longNums[j] == longNums[j - 1]) {
                    continue;
                }
                if (longNums[i] + longNums[j] + longNums[j + 1] + longNums[j + 2] > target) {
                    break;
                }
                if (longNums[i] + longNums[j] + longNums[len - 2] + longNums[len - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = longNums[i] + longNums[j] + longNums[left] + longNums[right];
                    if (sum == target) {
                        // res
                        resList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && longNums[left] == longNums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && longNums[right] == longNums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return resList;
    }
}
/*
18. 四数之和
https://leetcode.cn/problems/4sum/

给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
（若两个四元组元素一一对应，则认为两个四元组重复）：
- 0 <= a, b, c, d < n
- a、b、c 和 d 互不相同
- nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。
提示：
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

类似三数之和，注意会爆 int
 */