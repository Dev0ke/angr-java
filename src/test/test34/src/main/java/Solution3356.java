public class Solution3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, queries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == queries.length + 1 ? -1 : left;
    }

    private boolean checkMid(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] += val;
            diff[r + 1] -= val;
        }
        int[] origin = new int[n];
        origin[0] = diff[0];
        for (int i = 1; i < n; i++) {
            origin[i] = origin[i - 1] + diff[i];
        }
        for (int i = 0; i < n; i++) {
            if (origin[i] < nums[i]) return false;
        }
        return true;
    }
}
/*
3356. 零数组变换 II
https://leetcode.cn/problems/zero-array-transformation-ii/description/

第 424 场周赛 T3。

给你一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri, vali]。
每个 queries[i] 表示在 nums 上执行以下操作：
- 将 nums 中 [li, ri] 范围内的每个下标对应元素的值 最多 减少 vali。
- 每个下标的减少的数值可以独立选择。
零数组 是指所有元素都等于 0 的数组。
返回 k 可以取到的 最小非负 值，使得在 顺序 处理前 k 个查询后，nums 变成 零数组。如果不存在这样的 k，则返回 -1。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 5 * 10^5
1 <= queries.length <= 10^5
queries[i].length == 3
0 <= li <= ri < nums.length
1 <= vali <= 5

差分 + 二分答案。
时间复杂度 O(n + qlogn)。
相似题目: 3355. 零数组变换 I
https://leetcode.cn/problems/zero-array-transformation-i/description/
3362. 零数组变换 III
https://leetcode.cn/problems/zero-array-transformation-iii/description/
 */