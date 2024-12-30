import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionP267 {
    private Set<String> set;

    public List<String> generatePalindromes(String s) {
        int[] cntArr = new int[26];
        int cntOdd = 0;
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
            if (cntArr[ch - 'a'] % 2 == 0) {
                cntOdd--;
            } else {
                cntOdd++;
            }
        }
        // solution266 无法形成回文串
        if (cntOdd > 1) {
            return new ArrayList<>();
        }

        int len = s.length();
        set = new HashSet<>();
        char[] st = new char[len / 2];
        // 回文串 中心字符
        String middle = "";
        int k = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (cntArr[ch - 'a'] % 2 == 1) {
                middle = String.valueOf(ch);
            }
            for (int j = 0; j < cntArr[ch - 'a'] / 2; j++) {
                st[k++] = ch;
            }
        }
        // 排列
        permute(st, 0, middle);
        return new ArrayList<>(set);
    }

    private void permute(char[] st, int left, String middle) {
        if (left == st.length) {
            set.add(new String(st) + middle + new StringBuilder(new String(st)).reverse());
            return;
        }
        for (int i = left; i < st.length; i++) {
            if (st[left] != st[i] || left == i) {
                swap(st, left, i);
                permute(st, left + 1, middle);
                swap(st, left, i);
            }
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
/*
$267. 回文排列 II
https://leetcode.cn/problems/palindrome-permutation-ii/

给定一个字符串 s ，返回 其重新排列组合后可能构成的所有回文字符串，并去除重复的组合 。
你可以按 任意顺序 返回答案。如果 s 不能形成任何回文排列时，则返回一个空列表。
提示：
1 <= s.length <= 16
s 仅由小写英文字母组成

266 题判断 + 回溯
相似题目: $266. 回文排列
https://leetcode.cn/problems/palindrome-permutation/
 */