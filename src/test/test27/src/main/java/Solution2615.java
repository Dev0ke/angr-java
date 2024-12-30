import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxListMap.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        long[] arr = new long[n];
        for (List<Integer> ids : idxListMap.values()) {
            int sz = ids.size();
            if (sz == 1) continue;

            long sum = 0L;
            for (int i = 1; i < sz; i++) {
                sum += ids.get(i) - ids.get(0);
            }
            arr[ids.get(0)] = sum;

            for (int i = 1; i < sz; i++) {
                long d1 = ids.get(i) - ids.get(i - 1);
                sum -= (sz - 1L - i) * d1;
                sum += (i - 1L) * d1;
                arr[ids.get(i)] = sum;
            }
        }
        return arr;
    }
}
/*
2615. 等值距离和
https://leetcode.cn/problems/sum-of-distances/

第 340 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。
对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
返回数组 arr 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

相同元素分组 + 观察变化量。
据说是 2121 原题，但已经不记得了，又重新推了一遍规律。
时间复杂度 O(n)
相似题目: 2121. 相同元素的间隔之和
https://leetcode.cn/problems/intervals-between-identical-elements/
2602. 使数组元素全部相等的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/
 */