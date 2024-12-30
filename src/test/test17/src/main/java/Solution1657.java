import java.util.Arrays;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = counter(word1);
        int[] cnt2 = counter(word2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0 && cnt2[i] == 0 || cnt1[i] == 0 && cnt2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }

    private int[] counter(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        return cnt;
    }
}
/*
1657. 确定两个字符串是否接近
https://leetcode.cn/problems/determine-if-two-strings-are-close/description/

如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
- 操作 1：交换任意两个 现有 字符。
  - 例如，abcde -> aecdb
- 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
  - 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
你可以根据需要对任意一个字符串多次使用这两种操作。
给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
提示：
1 <= word1.length, word2.length <= 10^5
word1 和 word2 仅包含小写英文字母

计数。字符集相等 + 频次数组排序后相等。
时间复杂度 O(n1+n2+ClogC)
空间复杂度 O(C)
 */