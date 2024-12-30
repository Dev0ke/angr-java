public class Solution3163 {
    public String compressedString(String word) {
        int n = word.length();
        char[] s = word.toCharArray();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && i - st < 9 && s[i] == s[st]; i++) {
            }
            int cnt = i - st;
            ans.append(cnt).append(s[st]);
        }
        return ans.toString();
    }
}
/*
3163. 压缩字符串 III
https://leetcode.cn/problems/string-compression-iii/description/

第 399 场周赛 T2。

给你一个字符串 word，请你使用以下算法进行压缩：
- 从空字符串 comp 开始。当 word 不为空 时，执行以下操作：
  - 移除 word 的最长单字符前缀，该前缀由单一字符 c 重复多次组成，且该前缀长度 最多 为 9 。
  - 将前缀的长度和字符 c 追加到 comp 。
返回字符串 comp 。
提示：
1 <= word.length <= 2 * 10^5
word 仅由小写英文字母组成。

分组循环。
时间复杂度 O(n)。
 */