public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;
        if (len1 <= len2) {
            while (idx < len1) {
                stringBuilder.append(word1.charAt(idx));
                stringBuilder.append(word2.charAt(idx));
                idx++;
            }
            stringBuilder.append(word2.substring(idx));
        } else {
            while (idx < len2) {
                stringBuilder.append(word1.charAt(idx));
                stringBuilder.append(word2.charAt(idx));
                idx++;
            }
            stringBuilder.append(word1.substring(idx));
        }
        return stringBuilder.toString();
    }
}
/*
1768. 交替合并字符串
https://leetcode.cn/problems/merge-strings-alternately/

给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
返回 合并后的字符串 。
提示：
1 <= word1.length, word2.length <= 100
word1 和 word2 由小写英文字母组成

双指针。
相似题目: 21. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/
88. 合并两个有序数组
https://leetcode.cn/problems/merge-sorted-array/
 */
