import java.util.ArrayList;
import java.util.List;

public class Solution784 {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> resList = new ArrayList<>();
        dfs(chars, resList, 0);
        return resList;
    }

    private void dfs(char[] chars, List<String> resList, int idx) {
        if (idx == chars.length) {
            resList.add(new String(chars));
        } else {
            char oldCh = chars[idx];
            if (Character.isLowerCase(oldCh)) {
                char newCh = Character.toUpperCase(oldCh);
                chars[idx] = newCh;
                dfs(chars, resList, idx + 1);
                chars[idx] = oldCh;
            } else if (Character.isUpperCase(oldCh)) {
                char newCh = Character.toLowerCase(oldCh);
                chars[idx] = newCh;
                dfs(chars, resList, idx + 1);
                chars[idx] = oldCh;
            }
            dfs(chars, resList, idx + 1);
        }
    }
}
/*
784. 字母大小写全排列
https://leetcode.cn/problems/letter-case-permutation/

给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
提示:
1 <= s.length <= 12
s 由小写英文字母、大写英文字母和数字组成

回溯
时间复杂度 O(2^n * n)
空间复杂度 O(2^n * n)
 */