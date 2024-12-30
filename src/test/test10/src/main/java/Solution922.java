import java.util.ArrayList;
import java.util.List;

public class Solution922 {
    // 6ms
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int v : nums) {
            if (v % 2 == 0) even.add(v);
            else odd.add(v);
        }

        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++) {
            ans[i * 2] = even.get(i);
            ans[i * 2 + 1] = odd.get(i);
        }
        return ans;
    }

    // 2ms
    public int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (i < n) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) j += 2;
                swap(nums, i, j);
            }
            i += 2;
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
922. 按奇偶排序数组 II
https://leetcode.cn/problems/sort-array-by-parity-ii/description/

给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
你可以返回 任何满足上述条件的数组作为答案 。
提示：
2 <= nums.length <= 2 * 10^4
nums.length 是偶数
nums 中一半是偶数
0 <= nums[i] <= 1000
进阶：可以不使用额外空间解决问题吗？

模拟。
相似题目: 905. 按奇偶排序数组
https://leetcode.cn/problems/sort-array-by-parity/
 */