import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和
        int sum = 0;
        // 前缀和 频次
        Map<Integer, Integer> sumCntMap = new HashMap<>();
        sumCntMap.put(0, 1);
        int res = 0;
        for (int num : nums) {
            sum += num;
            int find = sum - k;
            res += sumCntMap.getOrDefault(find, 0);
            sumCntMap.put(sum, sumCntMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
/*
560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/

给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
提示：
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7

朴素前缀和 时间复杂度是 O(n^2)
前缀和 + HashMap 优化
时间复杂度 O(n)
相似题目: 523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/
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
