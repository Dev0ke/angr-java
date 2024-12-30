import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;

        int sum = 0;
        Map<Integer, Integer> sumFirstMap = new HashMap<>();
        sumFirstMap.put(0, -1);
        int max = 0;
        for (int j = 0; j < len; j++) {
            sum += (nums[j] == 1) ? 1 : -1;

            if (sumFirstMap.containsKey(sum)) {
                int i = sumFirstMap.get(sum);
                max = Math.max(max, j - i);
            } else {
                sumFirstMap.put(sum, j);
            }
        }
        return max;
    }
}
/*
525. 连续数组
https://leetcode.cn/problems/contiguous-array/

给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
提示：
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1

前缀和 + 哈希表
将 0 看成 -1，等价于求最长和为 0 的连续子数组。
时间复杂度 O(n)
空间复杂度 O(n)
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
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */