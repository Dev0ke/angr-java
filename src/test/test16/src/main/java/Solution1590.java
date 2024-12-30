import java.util.HashMap;
import java.util.Map;

public class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;

        // sum(nums[i]) 模 p 余数是 k
        int k = 0;
        for (int num : nums) {
            k = (k + num) % p;
        }

        if (k == 0) {
            return 0;
        }
        // 否则需找最短连续子数组，其和模 p 余数也是 k
        // 模 p 下的前缀和
        int sumMod = 0;
        // 最后一次出现下标
        Map<Integer, Integer> sumModLastMap = new HashMap<>();
        sumModLastMap.put(0, -1);
        int min = len;
        for (int j = 0; j < len; j++) {
            sumMod = (sumMod + nums[j]) % p;
            int find = (sumMod - k + p) % p;
            if (sumModLastMap.containsKey(find)) {
                int i = sumModLastMap.get(find);
                min = Math.min(min, j - i);
            }
            sumModLastMap.put(sumMod, j);
        }
        return min == len ? -1 : min;
    }
}
/*
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/

给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
子数组 定义为原数组中连续的一组元素。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= p <= 10^9

前缀和 + HashMap
时间复杂度 O(n)
相似题目: 523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/
560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
930. 和相同的二元子数组
https://leetcode.cn/problems/binary-subarrays-with-sum/
974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/
1371. 每个元音包含偶数次的最长子字符串
https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */