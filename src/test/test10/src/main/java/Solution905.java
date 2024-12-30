import java.util.ArrayList;
import java.util.List;

public class Solution905 {
    // 5ms
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int v : nums) {
            if (v % 2 == 0) even.add(v);
            else odd.add(v);
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::intValue).toArray();
    }

    // 0ms
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] % 2 == 1 && nums[r] % 2 == 0) {
                swap(nums, l, r);
                l++;
                r--;
            } else if (nums[l] % 2 == 0) {
                l++;
            } else if (nums[r] % 2 == 1) {
                r--;
            }
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
/*
905. 按奇偶排序数组
https://leetcode.cn/problems/sort-array-by-parity/

给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
返回满足此条件的 任一数组 作为答案。
提示：
1 <= nums.length <= 5000
0 <= nums[i] <= 5000

暴力模拟 / 双指针。
时间复杂度 O(n)。
相似题目: 922. 按奇偶排序数组 II
https://leetcode.cn/problems/sort-array-by-parity-ii/description/
 */