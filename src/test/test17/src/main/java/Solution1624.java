import java.util.Arrays;

public class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] idxArr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(idxArr[i], -1);
        }
        // 预处理每个字符首次出现和最后一次出现的下标
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (idxArr[idx][0] == -1) {
                idxArr[idx][0] = i;
            } else {
                idxArr[idx][1] = i;
            }
        }

        int res = -1;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, idxArr[i][1] - idxArr[i][0] - 1);
        }
        return res;
    }
}
/*
1624. 两个相同字符之间的最长子字符串
https://leetcode.cn/problems/largest-substring-between-two-equal-characters/

给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
子字符串 是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 300
s 只含小写英文字母

记录每个字符首次出现和最后一次出现的下标，枚举最大长度即可。
 */