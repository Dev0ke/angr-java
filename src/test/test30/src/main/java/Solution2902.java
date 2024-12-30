import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2902 {
    private static final int MOD = (int) (1e9 + 7);

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int tot = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (Integer x : nums) {
            tot += x;
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        if (l > tot) return 0;
        r = Math.min(r, tot);

        long[] f = new long[r + 1];
        f[0] = cntMap.getOrDefault(0, 0) + 1;
        cntMap.remove(0);

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int x = entry.getKey(), c = entry.getValue();

            // 朴素 DP
//            for (int j = r; j >= x; j--) {
//                for (int k = 1; k <= c && k * x <= j; k++) {
//                    f[j] += f[j - k * x];
//                    f[j] %= MOD;
//                }
//            }

            // 滑动窗口优化
            long[] newF = f.clone();
            // 到目前为止，能选的元素和至多为 sum
            sum = Math.min(sum + x * c, r);
            // 把循环上界从 r 改成 sum 可以快不少
            for (int j = x; j <= sum; j++) {
                newF[j] += newF[j - x];
                newF[j] %= MOD;
                if (j >= (c + 1) * x) {
                    newF[j] -= f[j - (c + 1) * x];
                    newF[j] = (newF[j] % MOD + MOD) % MOD;
                }
            }
            f = newF;
        }

        long ans = 0;
        for (int i = l; i <= r; i++) {
            ans += f[i];
            ans %= MOD;
        }
        return (int) ans;
    }
}
/*
2902. 和带限制的子多重集合的数目
https://leetcode.cn/problems/count-of-sub-multisets-with-bounded-sum/description/

第 115 场双周赛 T4。

给你一个下标从 0 开始的非负整数数组 nums 和两个整数 l 和 r 。
请你返回 nums 中子多重集合的和在闭区间 [l, r] 之间的 子多重集合的数目 。
由于答案可能很大，请你将答案对 10^9 + 7 取余后返回。
子多重集合 指的是从数组中选出一些元素构成的 无序 集合，每个元素 x 出现的次数可以是 0, 1, ..., occ[x] 次，其中 occ[x] 是元素 x 在数组中的出现次数。
注意：
- 如果两个子多重集合中的元素排序后一模一样，那么它们两个是相同的 子多重集合 。
- 空 集合的和是 0 。
提示：
1 <= nums.length <= 2 * 10^4
0 <= nums[i] <= 2 * 10^4
nums 的和不超过 2 * 10^4 。
0 <= l <= r <= 2 * 10^4

多重背包求方案数，滑动窗口优化
相似题目: 2585. 获得分数的方法数
https://leetcode.cn/problems/number-of-ways-to-earn-points/
 */