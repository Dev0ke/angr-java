public class Solution2062 {
    public int countVowelSubstrings(String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 4; j < word.length(); j++) {
                if (check(word, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean check(String word, int start, int end) {
        if (end - start < 4) {
            return false;
        }
        boolean[] aeiouArray = new boolean[5];
        for (int i = start; i <= end; i++) {
            char ch = word.charAt(i);
            if (!"aeiou".contains(String.valueOf(ch))) {
                return false;
            } else {
                for (int j = 0; j < 5; j++) {
                    if ("aeiou".charAt(j) == ch) {
                        aeiouArray[j] = true;
                    }
                }
            }
        }
        for (boolean bool : aeiouArray) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }
}
/*
2062. 统计字符串中的元音子字符串
https://leetcode.cn/problems/count-vowel-substrings-of-a-string/

第 266 场周赛 T1。

子字符串 是字符串中的一个连续（非空）的字符序列。
元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
提示：
1 <= word.length <= 100
word 仅由小写英文字母组成

看到 word.length <= 100，直接 O(n^3) 暴力即可。
 */