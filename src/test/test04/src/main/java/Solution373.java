import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {
    /**
     * 优先队列（大顶堆）
     * 时间复杂度 O(k^2logk)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0] + o2[1], o1[0] + o1[1]));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() >= k) {
                    int[] peek = maxHeap.element();
                    if (peek[0] + peek[1] > nums1[i] + nums2[j]) {
                        maxHeap.remove();
                        maxHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                } else {
                    maxHeap.add(new int[]{nums1[i], nums2[j]});
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] value = maxHeap.remove();
            resList.add(List.of(value[0], value[1]));
        }
        return resList;
    }

    /**
     * 优先队列（小顶堆）
     * 时间复杂度 O(klogk)
     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap
                = new PriorityQueue<>(Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                minHeap.add(new int[]{i, 0});
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        while (k > 0 && !minHeap.isEmpty()) {
            int[] ids = minHeap.remove();
            resList.add(List.of(nums1[ids[0]], nums2[ids[1]]));
            if (ids[1] < nums2.length - 1) {
                minHeap.add(new int[]{ids[0], ids[1] + 1});
            }
            k--;
        }
        return resList;
    }
}
/*
373. 查找和最小的K对数字
https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/

给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
定义一对值(u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
请找到和最小的 k 个数对(u1,v1), (u2,v2) ... (uk,vk)。
提示:
1 <= nums1.length, nums2.length <= 10^5
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1 和 nums2 均为升序排列
1 <= k <= 1000

优先队列（小顶堆/大顶堆）
 */