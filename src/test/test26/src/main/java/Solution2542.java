import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i, nums1[i], nums2[i]));
        }
        // 大到小排序，枚举 min(nums2[i]) 范围 [k-1, n-1]
        list.sort((o1, o2) -> Integer.compare(o2.n2, o1.n2));

        // 大小为 k 的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        // [0, k-1]
        for (int i = 0; i < k; i++) {
            int n1 = list.get(i).n1;
            minHeap.add(n1);
            sum += n1;
        }
        long min = list.get(k - 1).n2;
        long res = sum * min;

        // [k, n-1]
        for (int i = k; i < n; i++) {
            int n1 = list.get(i).n1;
            min = list.get(i).n2;

            int top = minHeap.element();
            if (n1 > top) {
                minHeap.add(n1);
                sum -= minHeap.remove();
                sum += n1;
            }
            res = Math.max(res, sum * min);

        }
        return res;
    }

    private static class Node {
        int id;
        int n1;
        int n2;

        public Node(int id, int n1, int n2) {
            this.id = id;
            this.n1 = n1;
            this.n2 = n2;
        }
    }
}
/*
2542. 最大子序列的分数
https://leetcode.cn/problems/maximum-subsequence-score/

第 96 场双周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
- nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
- 用公示表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
请你返回 最大 可能的分数。
一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[j] <= 10^5
1 <= k <= n

将 nums1 和 nums2 组合起来后按 nums2 由大至小排序。枚举 nums2[i] 取值范围为 [k-1, n-1]
同时用最小堆维护 k 个 nums1 最大值。
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 703. 数据流中的第 K 大元素
https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 */