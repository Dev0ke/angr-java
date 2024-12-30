import java.util.List;

public class Solution2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int c = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = searchInts(nums, j + 1, nums.get(i));
            if (j < n) c++;
        }
        return Math.max(n % 2, n - c * 2);
    }

    private int searchInts(List<Integer> a, int fromIndex, int key) {
        int l = fromIndex, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2856. 删除数对后的最小数组长度
https://leetcode.cn/problems/minimum-array-length-after-pair-removals/

第 113 场双周赛 T2。

给你一个下标从 0 开始的 非递减 整数数组 nums 。
你可以执行以下操作任意次：
- 选择 两个 下标 i 和 j ，满足 i < j 且 nums[i] < nums[j] 。
- 将 nums 中下标在 i 和 j 处的元素删除。剩余元素按照原来的顺序组成新的数组，下标也重新从 0 开始编号。
请你返回一个整数，表示执行以上操作任意次后（可以执行 0 次），nums 数组的 最小 数组长度。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 是 非递减 数组。

比赛时狂 WA 6 发。。
将 nums 看作两个数组 a, b，每个 a 连一条线到 b（最小大于 ai 的下标），这些线一定不会交叉。线的数量就是最大配对数。
时间复杂度 O(n)
如果转换成出现次数最多数的频次，有 O(logn) 解法
 */