import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int ps = 0;
        cntMap.put(ps, 1);
        for (Integer x : nums) {
            if (x % modulo == k) ps++;
            // (ps[r+1] - ps[l]) % m == k % m
            // 移项得 (ps[r+1] - k) % m == ps[l] % m
            int psSubK = ((ps - k) % modulo + modulo) % modulo;
            ans += cntMap.getOrDefault(psSubK, 0);
            int psMod = ps % modulo;
            cntMap.put(psMod, cntMap.getOrDefault(psMod, 0) + 1);
        }
        return ans;
    }
}
/*
2845. 统计趣味子数组的数目
https://leetcode.cn/problems/count-of-interesting-subarrays/

第 361 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。
请你找出并统计数组中 趣味子数组 的数目。
如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ：
- 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
以整数形式表示并返回趣味子数组的数目。
注意：子数组是数组中的一个连续非空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= modulo <= 10^9
0 <= k < modulo

前缀和 + 哈希表 + 同余
 */