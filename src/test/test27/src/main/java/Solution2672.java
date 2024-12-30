public class Solution2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];

        int q = queries.length;
        int same = 0;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int index = queries[i][0], color = queries[i][1];
            // 已经被染色
            if (nums[index] > 0) {
                if (index - 1 >= 0 && nums[index - 1] == nums[index]) {
                    same--;
                }
                if (index + 1 < n && nums[index + 1] == nums[index]) {
                    same--;
                }
            }
            if (index - 1 >= 0 && nums[index - 1] == color) {
                same++;
            }
            if (index + 1 < n && nums[index + 1] == color) {
                same++;
            }
            // 染色
            nums[index] = color;

            res[i] = same;
        }
        return res;
    }
}
/*
2672. 有相同颜色的相邻元素数目
https://leetcode.cn/problems/number-of-adjacent-elements-with-the-same-color/

第 344 场周赛 T3。

给你一个下标从 0 开始、长度为 n 的数组 nums 。一开始，所有元素都是 未染色 （值为 0 ）的。
给你一个二维整数数组 queries ，其中 queries[i] = [indexi, colori] 。
对于每个操作，你需要将数组 nums 中下标为 indexi 的格子染色为 colori 。
请你返回一个长度与 queries 相等的数组 answer ，其中 answer[i]是前 i 个操作 之后 ，相邻元素颜色相同的数目。
更正式的，answer[i] 是执行完前 i 个操作后，0 <= j < n - 1 的下标 j 中，满足 nums[j] == nums[j + 1] 且 nums[j] != 0 的数目。
提示：
1 <= n <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= indexi <= n - 1
1 <=  colori <= 10^5

模拟
时间复杂度 O(n)
 */