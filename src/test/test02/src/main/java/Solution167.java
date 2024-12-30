import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution167 {
    /**
     * 二分法
     * 时间复杂度 O(nlogn)
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            int want = target - cur;
            // 有可能不是严格递增，但因为 i 是从左到右的，如果 right 等于 i，那么 right = i + 1 即可；如果 right 不等于 i，无需处理
            int right = Arrays.binarySearch(numbers, want);
            if (right >= 0) {
                if (right == i) {
                    right = i + 1;
                }
                return new int[]{i + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * HashMap 法
     * 时间复杂度 O(n)
     */
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.put(numbers[i], i);
        }

        for (int i = 0; i < len; i++) {
            int want = target - numbers[i];
            if (idxMap.containsKey(want) && idxMap.get(want) != i) {
                // 下标 从 1 开始计数
                return new int[]{i + 1, idxMap.get(want) + 1};
            }
        }
        return new int[0];
    }

    /**
     * 双指针
     * 时间复杂度 O(n)
     */
    public int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return new int[]{-1, -1};
    }
}
/*
167. 两数之和 II - 输入有序数组
https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
你所设计的解决方案必须只使用常量级的额外空间。
提示：
2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案

第 1 题两数之和的简化版。没错，确实是简化版，区别在于第 1 题数组无序，这题数组有序。
HashMap 解法: 时间复杂度 O(n)
二分搜索解法: 时间复杂度 O(nlogn), 本题二分搜索并不是优选方法
 */