import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        // 模 k 下的前缀和
        int sumMod = 0;
        // 首次出现下标
        Map<Integer, Integer> sumModFirstMap = new HashMap<>();
        sumModFirstMap.put(0, -1);
        for (int j = 0; j < len; j++) {
            sumMod = (sumMod + nums[j]) % k;
            if (sumModFirstMap.containsKey(sumMod)) {
                int i = sumModFirstMap.get(sumMod);
                if (j - i >= 2) {
                    return true;
                }
            } else {
                sumModFirstMap.put(sumMod, j);
            }
        }
        return false;
    }
}
/*
523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/

给你一个整数数组 nums 和一个整数  k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
- 子数组大小 至少为 2 ，且
- 子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。
如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= sum(nums[i]) <= 2^31 - 1
1 <= k <= 2^31 - 1

前缀和 + 同余 + HashMap
时间复杂度 O(n)
相似题目: 560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
930. 和相同的二元子数组
https://leetcode.cn/problems/binary-subarrays-with-sum/
974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/
1371. 每个元音包含偶数次的最长子字符串
https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */