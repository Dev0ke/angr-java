import java.util.HashSet;
import java.util.Set;

public class Solution2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        // 前后缀分解
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            pre[i] = set.size();
        }

        set.clear();
        int[] suf = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = set.size();
            set.add(nums[i]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] - suf[i];
        }
        return res;
    }
}
/*
2670. 找出不同元素数目差数组
https://leetcode.cn/problems/find-the-distinct-difference-array/

第 344 场周赛 T1。

给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
返回 nums 的 不同元素数目差 数组。
注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
提示：
1 <= n == nums.length <= 50
1 <= nums[i] <= 50

前后缀分解。
时间复杂度 O(n)
 */