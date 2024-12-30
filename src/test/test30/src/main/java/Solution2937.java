public class Solution2937 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        String lcp = getLCP(getLCP(s1, s2), s3);
        if (lcp.isEmpty()) {
            return -1;
        }
        return s1.length() + s2.length() + s3.length() - lcp.length() * 3;
    }

    private String getLCP(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLen);
    }
}
/*
2937. 使三个字符串相等
https://leetcode.cn/problems/make-three-strings-equal/description/

第 372 场周赛 T1。

给你三个字符串 s1、s2 和 s3。 你可以根据需要对这三个字符串执行以下操作 任意次数 。
在每次操作中，你可以选择其中一个长度至少为 2 的字符串 并删除其 最右位置上 的字符。
如果存在某种方法能够使这三个字符串相等，请返回使它们相等所需的 最小 操作次数；否则，返回 -1。
提示：
1 <= s1.length, s2.length, s3.length <= 100
s1、s2 和 s3 仅由小写英文字母组成。

模拟。
相似题目: 14. 最长公共前缀
https://leetcode.cn/problems/longest-common-prefix/
 */