import java.util.Arrays;
import java.util.Comparator;

public class Solution2659 {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, nums[i]);
        }
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.val));

        // 第 k 轮剩余的元素个数
        int remain = n;
        long res = remain;
        for (int i = 1; i < n; i++) {
            remain--;
            // 开始新的一轮
            if (nodes[i - 1].id > nodes[i].id) {
                res += remain;
            }
        }
        return res;
    }

    private static class Node {
        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
}
/*
2659. 将数组清空
https://leetcode.cn/problems/make-array-empty/

第 103 场双周赛 T4。

给你一个包含若干 互不相同 整数的数组 nums ，你需要执行以下操作 直到数组为空 ：
- 如果数组中第一个元素是当前数组中的 最小值 ，则删除它。
- 否则，将第一个元素移动到数组的 末尾 。
请你返回需要多少个操作使 nums 为空。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 中的元素 互不相同 。

组合排序。将数组值和下标组合排序。每轮扫过去，下标单调递增的归属同一轮。假设第 k 轮长度为 remain，则每轮答案加上 remain。
时间复杂度 O(nlogn)
 */