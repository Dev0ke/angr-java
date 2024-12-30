import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0])); // 左端点升序
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 右端点越大越好
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            while (j < queries.length && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }
            while (sumD < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sumD++;
                diff[pq.remove() + 1]--;
            }
            if (sumD < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
/*
3362. 零数组变换 III
https://leetcode.cn/problems/zero-array-transformation-iii/description/

第 144 场双周赛 T3。

给你一个长度为 n 的整数数组 nums 和一个二维数组 queries ，其中 queries[i] = [li, ri] 。
每一个 queries[i] 表示对于 nums 的以下操作：
- 将 nums 中下标在范围 [li, ri] 之间的每一个元素 最多 减少 1 。
- 坐标范围内每一个元素减少的值相互 独立 。
零数组 指的是一个数组里所有元素都等于 0 。
请你返回 最多 可以从 queries 中删除多少个元素，使得 queries 中剩下的元素仍然能将 nums 变为一个 零数组 。如果无法将 nums 变为一个 零数组 ，返回 -1 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
0 <= li <= ri < nums.length

贪心+最大堆+差分数组
相似题目: 871. 最低加油次数
https://leetcode.cn/problems/minimum-number-of-refueling-stops/
3355. 零数组变换 I
https://leetcode.cn/problems/zero-array-transformation-i/description/
3356. 零数组变换 II
https://leetcode.cn/problems/zero-array-transformation-ii/description/
rating 2415 (clist.by)
 */