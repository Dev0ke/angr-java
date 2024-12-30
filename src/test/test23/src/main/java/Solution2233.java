import java.util.PriorityQueue;

public class Solution2233 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        for (int i = 0; i < k; i++) {
            int remove = minHeap.remove();
            minHeap.add(remove + 1);
        }

        // res
        long res = 1;
        long mod = 1000000007;
        for (Integer integer : minHeap) {
            res = (res * integer) % mod;
        }
        return (int) res;
    }
}
/*
2233. K 次增加后的最大乘积
https://leetcode.cn/problems/maximum-product-after-k-increments/

第 288 场周赛 T3。

给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。
请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 10^9 + 7 取余后返回。
提示：
1 <= nums.length, k <= 10^5
0 <= nums[i] <= 10^6

数论知识，和相等的情况下，数值越接近的数的乘积越大。
因此将数组预处理为最接近的数组即可。
时间复杂度 O(nlogn) 优先队列的复杂度
 */