public class Solution1915 {
    public long wonderfulSubstrings(String word) {
        // 前缀和（sumMod2Mask[i] = 0 表示该字母出现偶数次，sumMod2Mask[i] = 1 表示该字母出现奇数次）
        int sumMod2Mask = 0;

        // 该字符串由前十个小写英文字母组成（'a' 到 'j'）
        // 某个前缀和出现了多少次
        int[] cnt = new int[1 << 10];
        cnt[0] = 1;
        long res = 0L;
        for (char ch : word.toCharArray()) {
            // 模2 下的加法 相当于 异或
            sumMod2Mask ^= 1 << (ch - 'a');

            // 所有字母均出现偶数次
            res += cnt[sumMod2Mask];

            // 枚举其中一个字母出现奇数次
            for (int k = 1; k < (1 << 10); k = k << 1) {
                res += cnt[sumMod2Mask ^ k];
            }
            cnt[sumMod2Mask]++;
        }
        return res;
    }
}
/*
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/

第 247 场周赛 T3。

如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。
- 例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。
如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。
子字符串 是字符串中的一个连续字符序列。
提示：
1 <= word.length <= 10^5
word 由从 'a' 到 'j' 的小写英文字母组成

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
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
 */