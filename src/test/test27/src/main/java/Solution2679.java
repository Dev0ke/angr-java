import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2679 {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        List<PriorityQueue<Integer>> maxHeaps = new ArrayList<>();
        for (int[] x : nums) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < n; j++) {
                maxHeap.add(x[j]);
            }
            maxHeaps.add(maxHeap);
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, maxHeaps.get(i).remove());
            }
            ans += max;
        }
        return ans;
    }
}
/*
2679. 矩阵中的和
https://leetcode.cn/problems/sum-in-a-matrix/

第 104 场双周赛 T2。

给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
1.矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
2.在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
请你返回最后的 分数 。
提示：
1 <= nums.length <= 300
1 <= nums[i].length <= 500
0 <= nums[i][j] <= 10^3

最大堆
时间复杂度 O(mnlogn)
 */