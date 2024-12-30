import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionP2143 {
    private static final int MOD = (int) (1e9 + 7);

    public int countSubranges(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Long>[] dp = new HashMap[n];
        Arrays.setAll(dp, e -> new HashMap<>());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i].merge(nums1[i], 1L, Long::sum);
            dp[i].merge(-nums2[i], 1L, Long::sum);
            if (i - 1 >= 0) {
                for (Integer preSum : dp[i - 1].keySet()) {
                    dp[i].merge(preSum + nums1[i], dp[i - 1].get(preSum), (a, b) -> (a + b) % MOD);
                    dp[i].merge(preSum - nums2[i], dp[i - 1].get(preSum), (a, b) -> (a + b) % MOD);
                }
            }
            ans += dp[i].getOrDefault(0, 0L);
            ans %= MOD;
        }
        return (int) ans;
    }
}
/*
$2143. 在两个数组的区间中选取数字
https://leetcode.cn/problems/choose-numbers-from-two-arrays-in-range/description/

给你两个 下标从 0 开始，长度为 n 的整数数组 nums1 和 nums2。
如果一个区间 [l, r] （包含左右端点，0 <= l <= r < n）满足下列条件，那么这个区间就是 平衡 的：
- 对每个在区间 [l, r] 范围内的 i，你需要选取 nums1[i] 或者 nums2[i]；
- 从 nums1 中选取的数字和与从 nums2 中选取的数字和相等。（如果你没有从某个数组中选取任何数字，那么数字和被视为 0）。
如果两个 平衡 的区间 [l1, r1] 和 [l2, r2] 满足下列条件之一，那么它们就是 不同 的：
- l1 != l2
- r1 != r2
- 两个区间中的数字选取情况不同（也就是说，存在至少一个 i，使得在第一个区间中，nums1[i] 被选中, 而在第二个区间中，nums2[i] 被选中，或者相反的情况）。
请返回 不同 的平衡的区间数目。由于答案可能很大，请返回答案 模 10^9+7 的结果。
提示:
n == nums1.length == nums2.length
1 <= n <= 100
0 <= nums1[i], nums2[i] <= 100

字典dp。dp[i][sum]表示以索引i结尾的子数组前缀和为sum的有多少个
https://leetcode.cn/problems/choose-numbers-from-two-arrays-in-range/solutions/1223706/qian-zhui-he-dp-by-981377660lmt-vg09/
相似题目: 956. 最高的广告牌
https://leetcode.cn/problems/tallest-billboard/description/
 */