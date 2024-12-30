import java.util.HashMap;
import java.util.Map;

public class Solution2183 {
    /**
     * HashMap gcd
     * 时间复杂度 O(nlogk + k)
     */
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            int gcd = getGCD(num, k);
            cntMap.put(gcd, cntMap.getOrDefault(gcd, 0) + 1);
        }

        long cnt = 0;
        // √k * √k = k
        for (Map.Entry<Integer, Integer> entry1 : cntMap.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : cntMap.entrySet()) {
                if ((long) entry1.getKey() * entry2.getKey() % k == 0) {
                    cnt += (long) entry1.getValue() * entry2.getValue();
                }
            }
        }

        // 去重 [i, i] 会被枚举一次
        for (int num : nums) {
            if ((long) num * num % k == 0) {
                cnt--;
            }
        }
        // 去重 [i, j] 会被枚举两次
        return cnt / 2;
    }

    // gcd 时间复杂度 O(logk)
    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

    /**
     * 暴力解法 - TLE
     * 时间复杂度 O(n^2)
     */
    public long countPairs2(int[] nums, int k) {
        int len = nums.length;

        long cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((long) nums[i] * nums[j] % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2183. 统计可以被 K 整除的下标对数目
https://leetcode.cn/problems/count-array-pairs-divisible-by-k/

第 281 场周赛 T4。

给你一个下标从 0 开始、长度为 n 的整数数组 nums 和一个整数 k ，返回满足下述条件的下标对 (i, j) 的数目：
- 0 <= i < j <= n - 1 且
- nums[i] * nums[j] 能被 k 整除。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^5

乍一看很像前一晚双周赛的 T1（连方法名/参数都一样）。暴力解法时间复杂度 O(n^2) 数量级 10^5 无法 AC。
需要求出 gcd(num, k) 频次进行优化。
容易证明：若 nums[i] * nums[j] % k == 0，则有 gcd(nums[i], k) * gcd(nums[j], k) % k == 0
注意需要去除重复统计的项。
 */