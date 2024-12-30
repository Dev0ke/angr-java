import java.util.HashMap;
import java.util.Map;

public class SolutionP2964 {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> S1 = new HashMap<>();
        Map<Integer, Integer> S2 = new HashMap<>();

        // 初始化S2
        for (int x : nums) {
            S2.put(x % d, S2.getOrDefault(x % d, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            S2.put(x % d, S2.get(x % d) - 1);
            if (i > 0) {
                int prevMod = nums[i - 1] % d;
                S1.put(prevMod, S1.getOrDefault(prevMod, 0) + 1);
            }
            for (int s : S1.keySet()) {
                int complement = (2 * d - x % d - s) % d;
                if (S2.containsKey(complement)) {
                    res += S1.get(s) * S2.get(complement);
                }
            }
        }
        return res;
    }
}
/*
$2964. 可被整除的三元组数量
https://leetcode.cn/problems/number-of-divisible-triplet-sums/description/

给定一个 下标从 0 开始 的整数数组 nums 和一个整数 d，请返回满足 i < j < k 且 (nums[i] + nums[j] + nums[k]) % d == 0 的三元组 (i, j, k) 的数量。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= d <= 10^9

固定中间数，左右两侧分别用字典统计取模为d的数值个数，左右侧数量相乘即可。
https://leetcode.cn/problems/number-of-divisible-triplet-sums/solutions/2585533/gu-ding-zhong-jian-shu-zuo-you-liang-ce-8eqsy/
 */