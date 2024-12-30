import java.util.HashMap;
import java.util.Map;

public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int len = s.length();

        // 前缀和（sumMod2Mask[i] = 0 表示该字母出现偶数次，sumMod2Mask[i] = 1 表示该字母出现奇数次）
        int sumMod2Mask = 0;

        // 首次出现下标
        Map<Integer, Integer> sumModFirstMap = new HashMap<>();
        sumModFirstMap.put(0, -1);
        int max = 0;
        for (int j = 0; j < len; j++) {
            char ch = s.charAt(j);
            if ("aeiou".indexOf(ch) >= 0) {
                // 模2 下的加法相当于 异或
                sumMod2Mask ^= 1 << (ch - 'a');
            }

            if (sumModFirstMap.containsKey(sumMod2Mask)) {
                int i = sumModFirstMap.get(sumMod2Mask);
                max = Math.max(max, j - i);
            } else {
                sumModFirstMap.put(sumMod2Mask, j);
            }
        }
        return max;
    }
}
/*
1371. 每个元音包含偶数次的最长子字符串
https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/

给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
提示：
1 <= s.length <= 5 x 10^5
s 只包含小写英文字母。

前缀和 + 状态压缩 + 异或 + HashMap
时间复杂度 O(n)
相似题目: 523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/
560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
930. 和相同的二元子数组
https://leetcode.cn/problems/binary-subarrays-with-sum/
974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */