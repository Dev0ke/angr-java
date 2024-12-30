import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution2354 {
    public long countExcellentPairs(int[] nums, int k) {
        // bitCount(num) -> num
        TreeMap<Integer, Set<Integer>> bitCountTreeMap = new TreeMap<>();
        for (int num : nums) {
            int bitCount = Integer.bitCount(num);
            bitCountTreeMap.computeIfAbsent(bitCount, key -> new HashSet<>()).add(num);
        }

        long cnt = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : bitCountTreeMap.entrySet()) {
            int bitCount1 = entry.getKey();
            long cnt1 = entry.getValue().size();
            Map<Integer, Set<Integer>> tailMap = bitCountTreeMap.tailMap(k - bitCount1);
            if (tailMap.isEmpty()) {
                continue;
            }
            for (Set<Integer> numSet : tailMap.values()) {
                long cnt2 = numSet.size();
                cnt += cnt1 * cnt2;
            }
        }
        return cnt;
    }
}
/*
2354. 优质数对的数目
https://leetcode.cn/problems/number-of-excellent-pairs/

第 303 场周赛 T4。

给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。
如果满足下述条件，则数对 (num1, num2) 是 优质数对 ：
- num1 和 num2 都 在数组 nums 中存在。
- num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按位 与 操作。
返回 不同 优质数对的数目。
如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。
注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 60

num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和 等价于 num1 和 num2 二进制 1 数量的和。
观察出这一规律后，简单统计求和 即可。
相似题目: 1782. 统计点对的数目
https://leetcode.cn/problems/count-pairs-of-nodes/
 */