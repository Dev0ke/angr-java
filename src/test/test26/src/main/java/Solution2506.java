public class Solution2506 {
    public int similarPairs(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                mask[i] |= 1 << (ch - 'a');
            }
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (mask[i] == mask[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2506. 统计相似字符串对的数目
https://leetcode.cn/problems/count-pairs-of-similar-strings/

第 324 场周赛 T1。

给你一个下标从 0 开始的字符串数组 words 。
如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
- 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
- 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= word.length - 1 。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] 仅由小写英文字母组成

暴力，可以将每个字符串状态压缩成一个整数。
 */