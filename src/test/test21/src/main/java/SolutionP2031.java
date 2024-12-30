import java.util.HashMap;
import java.util.Map;

public class SolutionP2031 {
    private static final int MOD = (int) (1e9 + 7);

    // 将 0 用 -1 替代, s[i] 表示 nums[0, i] 的和
    // 若 nums[i] = 0, 则 s[i] = s[i-1]-1, cnt -= mp[s[i]]
    // 若 nums[i] = 1, 则 s[i] = s[i-1]+1, cnt += mp[s[i-1]]
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(n, 1);
        int s = n;
        long ans = 0, cnt = 0;
        for (int v : nums) {
            if (v == 1) cnt += mp.getOrDefault(s++, 0);
            else cnt -= mp.getOrDefault(--s, 0);
            mp.merge(s, 1, Integer::sum);
            ans = (ans + cnt) % MOD;
        }
        return (int) ans;
    }
}
/*
$2031. 1 比 0 多的子数组个数
https://leetcode.cn/problems/count-subarrays-with-more-ones-than-zeros/description/

给你一个只包含 0 和 1 的数组 nums，请返回 1 的数量 大于 0 的数量的子数组的个数。由于答案可能很大，请返回答案对 10^9 + 7 取余 的结果。
一个 子数组 指的是原数组中连续的一个子序列。
提示:
1 <= nums.length <= 10^5
0 <= nums[i] <= 1

前缀和。
时间复杂度 O(n)。
 */