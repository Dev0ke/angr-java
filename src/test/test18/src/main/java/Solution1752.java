import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1752 {
    public boolean check(int[] nums) {
        int min = Arrays.stream(nums).min().orElseThrow();
        int len = nums.length;
        List<Integer> minIdxList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] == min) {
                minIdxList.add(i);
            }
        }

        for (int minIdx : minIdxList) {
            if (check(nums, minIdx)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] nums, int minIdx) {
        int len = nums.length;
        // 比较 n-1 次
        for (int i = 0; i < len - 1; i++) {
            if (nums[(i + minIdx) % len] > nums[(i + minIdx + 1) % len]) {
                return false;
            }
        }
        return true;
    }
}
/*
1752. 检查数组是否经排序和轮转得到
https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/

给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
源数组中可能存在 重复项 。
注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

遍历
可以优化至 O(n)
 */