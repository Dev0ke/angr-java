import java.util.HashMap;
import java.util.Map;

public class Solution1814 {
    private static final int MOD = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            long key = num - rev(num);
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }

        long res = 0;
        for (long x : cntMap.values()) {
            res = (res + x * (x - 1) / 2) % MOD;
        }
        return (int) res;
    }

    private long rev(int num) {
        return Long.parseLong(new StringBuilder(String.valueOf(num)).reverse().toString());
    }
}
/*
1814. 统计一个数组中好对子的数目
https://leetcode.cn/problems/count-nice-pairs-in-an-array/

给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
- 0 <= i < j < nums.length
- nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
请你返回好下标对的数目。由于结果可能会很大，请将结果对 10^9 + 7 取余 后返回。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

HashMap + 计数
 */