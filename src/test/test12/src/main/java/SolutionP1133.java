import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionP1133 {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                maxHeap.add(entry.getKey());
            }
        }
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }
}
/*
$1133. 最大唯一数
https://leetcode.cn/problems/largest-unique-number/

第 5 场双周赛 T1。

给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
如果不存在这个只出现一次的整数，则返回 -1。
提示：
1 <= A.length <= 2000
0 <= A[i] <= 1000

HashMap 统计频次。
 */