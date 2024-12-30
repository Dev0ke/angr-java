import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionP2263 {
    public int convertArray(int[] nums) {
        int ans1 = getAns(nums);
        reverse(nums);
        int ans2 = getAns(nums);
        return Math.min(ans1, ans2);
    }

    private int getAns(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0;
        for (int v : nums) {
            if (!maxHeap.isEmpty() && v < maxHeap.peek()) {
                ans += maxHeap.remove() - v;
                maxHeap.add(v); // 为了保证斜率变化连续，一定要多添加一个左端点
            }
            maxHeap.add(v);
        }
        return ans;
    }

    private void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
$2263. 数组变为有序的最小操作次数
https://leetcode.cn/problems/make-array-non-decreasing-or-non-increasing/description/

给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以：
- 在范围 0 <= i < nums.length 内选出一个下标 i
- 将 nums[i] 的值变为 nums[i] + 1 或 nums[i] - 1
返回将数组 nums 变为 非递增 或 非递减 所需的 最小 操作次数。
提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
进阶：你可以设计并实现时间复杂度为 O(n*log(n)) 的解法吗?

斜率优化
https://leetcode.cn/problems/make-array-non-decreasing-or-non-increasing/solutions/1500406/xie-lu-you-hua-by-kkxbb-ufrf
相似题目: LCP 59. 搭桥过河
https://leetcode.cn/problems/NfY1m5/
 */