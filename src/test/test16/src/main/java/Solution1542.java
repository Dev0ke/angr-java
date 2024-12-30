import java.util.HashMap;
import java.util.Map;

public class Solution1542 {
    public int longestAwesome(String s) {
        int len = s.length();

        // 前缀和（sumMod2Mask[i] = 0 表示该字母出现偶数次，sumMod2Mask[i] = 1 表示该字母出现奇数次）
        int sumMod2Mask = 0;

        // 首次出现下标
        Map<Integer, Integer> sumModFirstMap = new HashMap<>();
        sumModFirstMap.put(0, -1);
        int max = 0;
        for (int j = 0; j < len; j++) {
            // 模2 下的加法 相当于 异或
            sumMod2Mask ^= 1 << (s.charAt(j) - '0');

            // 所有字母均出现偶数次
            if (sumModFirstMap.containsKey(sumMod2Mask)) {
                int i = sumModFirstMap.get(sumMod2Mask);
                max = Math.max(max, j - i);
            } else {
                sumModFirstMap.put(sumMod2Mask, j);
            }

            // 枚举其中一个字母出现奇数次
            for (int k = 1; k < (1 << 10); k = k << 1) {
                int mask = sumMod2Mask ^ k;
                if (sumModFirstMap.containsKey(mask)) {
                    int i = sumModFirstMap.get(mask);
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
/*
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/

给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
「超赞子字符串」需满足满足下述两个条件：
- 该字符串是 s 的一个非空子字符串
- 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
提示：
1 <= s.length <= 10^5
s 仅由数字组成

前缀和 + 状态压缩 + 异或 + HashMap
时间复杂度 O(n) 其中常数为 10
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
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */