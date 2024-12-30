import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1354 {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (long v : target) {
            sum += v;
            maxHeap.add(v);
        }
        while (sum != target.length) {
            long mx = maxHeap.remove(); // 最大的数
            long replace = sum - mx; // 被替换的数
            if (replace >= mx || replace == 0) return false;
            long pre = mx % replace > 0 ? mx % replace : replace; // 取模加速
            maxHeap.add(pre);
            sum += pre - mx;
        }
        return true;
    }
}
/*
1354. 多次求和构造目标数组
https://leetcode.cn/problems/construct-target-array-with-multiple-sums/description/

给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
- 令 x 为你数组里所有元素的和
- 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
- 你可以重复该过程任意次
如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
提示：
N == target.length
1 <= target.length <= 5 * 10^4
1 <= target[i] <= 10^9

反悔贪心？
时间复杂度 O(nlogS)。
 */