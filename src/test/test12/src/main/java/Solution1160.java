public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int[] base = cnt(chars);
        int ans = 0;
        for (String word : words) {
            int[] cnt = cnt(word);
            if (check(base, cnt)) {
                ans += word.length();
            }
        }
        return ans;
    }

    private boolean check(int[] base, int[] cnt) {
        for (int i = 0; i < 26; i++) {
            if (base[i] < cnt[i]) return false;
        }
        return true;
    }

    private int[] cnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return cnt;
    }
}
/*
1160. 拼写单词
https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/description/

给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
提示：
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母

枚举。
时间复杂度 O(26n)。
 */