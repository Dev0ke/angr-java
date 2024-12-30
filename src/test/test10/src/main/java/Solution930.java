import java.util.HashMap;
import java.util.Map;

public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // 前缀和
        int sum = 0;
        // 前缀和 频次
        Map<Integer, Integer> sumCntMap = new HashMap<>();
        sumCntMap.put(0, 1);
        int res = 0;
        for (int num : nums) {
            sum += num;
            int find = sum - goal;
            res += sumCntMap.getOrDefault(find, 0);
            sumCntMap.put(sum, sumCntMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
/*
930. 和相同的二元子数组
https://leetcode.cn/problems/binary-subarrays-with-sum/

给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
子数组 是数组的一段连续部分。
提示：
1 <= nums.length <= 3 * 10^4
nums[i] 不是 0 就是 1
0 <= goal <= nums.length

前缀和 + HashMap 优化
时间复杂度 O(n)
相似题目: 523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/
560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
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