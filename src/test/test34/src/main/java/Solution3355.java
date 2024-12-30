public class Solution3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] p : queries) {
            diff[p[0]]++;
            diff[p[1] + 1]--;
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
3355. 零数组变换 I
https://leetcode.cn/problems/zero-array-transformation-i/description/

第 424 场周赛 T2。

给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
对于每个查询 queries[i]：
- 在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
- 将选中的每个下标对应的元素值减 1。
零数组 是指所有元素都等于 0 的数组。
如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= li <= ri < nums.length

差分。
时间复杂度 O(n)。
相似题目: 3356. 零数组变换 II
https://leetcode.cn/problems/zero-array-transformation-ii/description/
3362. 零数组变换 III
https://leetcode.cn/problems/zero-array-transformation-iii/description/
 */