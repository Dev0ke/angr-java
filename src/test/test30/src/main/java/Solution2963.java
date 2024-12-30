import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2963 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> ranges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (!ranges.containsKey(x)) {
                ranges.put(x, new int[]{i, i});
            } else {
                ranges.get(x)[1] = i;
            }
        }
        // 合并区间
        List<int[]> intervals = new ArrayList<>(ranges.values());
        int sz = merge(intervals).size();
        return (int) quickPow(2, sz - 1);
    }

    private List<int[]> merge(List<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int l = p[0], r = p[1];
            if (!ans.isEmpty() && l <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], r);
            } else {
                ans.add(new int[]{l, r});
            }
        }
        return ans;
    }

    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
2963. 统计好分割方案的数目
https://leetcode.cn/problems/count-the-number-of-good-partitions/description/

第 375 场周赛 T4。

给你一个下标从 0 开始、由 正整数 组成的数组 nums。
将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。
返回 nums 的 好分割方案 的 数目。
由于答案可能很大，请返回答案对 10^9 + 7 取余 的结果。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

找出每个数字的区间（最左下标，最右下标）。然后合并区间。设区间个数为 m，则答案为 2^(m-1)。
时间复杂度 O(nlogn)
相似题目: 56. 合并区间
https://leetcode.cn/problems/merge-intervals/
 */