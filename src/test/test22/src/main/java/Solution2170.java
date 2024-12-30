import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2170 {
    public int minimumOperations(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        // 统计频次
        Map<Integer, Integer> cntEvenMap = new HashMap<>();
        Map<Integer, Integer> cntOddMap = new HashMap<>();
        int evenLen = 0;
        int oddLen = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                cntEvenMap.put(nums[i], cntEvenMap.getOrDefault(nums[i], 0) + 1);
                evenLen++;
            } else {
                cntOddMap.put(nums[i], cntOddMap.getOrDefault(nums[i], 0) + 1);
                oddLen++;
            }
        }

        // 排序
        PriorityQueue<int[]> evenMaxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        PriorityQueue<int[]> oddMaxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (Map.Entry<Integer, Integer> entry : cntEvenMap.entrySet()) {
            evenMaxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : cntOddMap.entrySet()) {
            oddMaxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int min = Integer.MAX_VALUE;
        int[] evenTop1 = evenMaxHeap.remove();
        int[] oddTop1 = oddMaxHeap.remove();
        if (evenTop1[0] != oddTop1[0]) {
            min = evenLen - evenTop1[1] + oddLen - oddTop1[1];
        } else {
            if (evenMaxHeap.isEmpty() && oddMaxHeap.isEmpty()) {
                min = Math.min(evenLen, oddLen);
            } else {
                if (!evenMaxHeap.isEmpty()) {
                    int[] evenTop2 = evenMaxHeap.remove();
                    min = evenLen - evenTop2[1] + oddLen - oddTop1[1];
                }
                if (!oddMaxHeap.isEmpty()) {
                    int[] oddTop2 = oddMaxHeap.remove();
                    int res = evenLen - evenTop1[1] + oddLen - oddTop2[1];
                    min = Math.min(min, res);
                }
            }
        }
        return min;
    }
}
/*
2170. 使数组变成交替数组的最少操作数
https://leetcode.cn/problems/minimum-operations-to-make-the-array-alternating/

第 280 场周赛 T2。

给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
如果满足下述条件，则数组 nums 是一个 交替数组 ：
- nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
- nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
返回使数组变成交替数组的 最少操作数 。

贪心。分别统计奇偶频次，然后选取操作数少的方案。
 */