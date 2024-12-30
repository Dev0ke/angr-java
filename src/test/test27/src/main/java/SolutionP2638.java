import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SolutionP2638 {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Map<Integer, TreeMap<Integer, Integer>> groups = new HashMap<>();
        for (int x : nums)
            groups.computeIfAbsent((x % k), key -> new TreeMap<>()).merge(x, 1, Integer::sum);
        long ans = 1;
        for (TreeMap<Integer, Integer> g : groups.values()) {
            int m = g.size();
            long[] f = new long[m + 1];
            f[0] = 1;
            int i = 1, pre = 0;
            for (Map.Entry<Integer, Integer> e : g.entrySet()) {
                int cur = e.getKey();
                if (i > 1 && cur - pre == k)
                    f[i] = f[i - 1] + f[i - 2] * ((1L << e.getValue()) - 1);
                else
                    f[i] = f[i - 1] << e.getValue();
                pre = cur;
                ++i;
            }
            ans *= f[m];
        }
        return ans;
    }
}
/*
$2638. 统计 K-Free 子集的总数
https://leetcode.cn/problems/count-the-number-of-k-free-subsets/description/

给定一个包含 无重复 元素的整数数组 nums 和一个整数 k 。
如果一个子集中 不 存在两个差的绝对值等于 k 的元素，则称其为 k-Free 子集。注意，空集是一个 k-Free 子集。
返回 nums 中 k-Free 子集的数量。
一个数组的 子集 是该数组中的元素的选择（可能为零个）。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 1000
1 <= k <= 1000

相似题目: 2597. 美丽子集的数目
https://leetcode.cn/problems/the-number-of-beautiful-subsets/
 */