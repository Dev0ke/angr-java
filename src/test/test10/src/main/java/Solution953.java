public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        int len = order.length();

        int[] orderArr = new int[len];
        for (int i = 0; i < len; i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], orderArr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String words1, String words2, int[] orderArr) {
        int idx = 0;
        while (idx < words1.length() && idx < words2.length()) {
            int ch1 = words1.charAt(idx) - 'a';
            int ch2 = words2.charAt(idx) - 'a';
            if (orderArr[ch1] < orderArr[ch2]) {
                return true;
            } else if (orderArr[ch1] > orderArr[ch2]) {
                return false;
            } else {
                idx++;
            }
        }
        // 短的单词排前面
        return idx == words1.length();
    }
}
/*
953. 验证外星语词典
https://leetcode.cn/problems/verifying-an-alien-dictionary/

第 114 场周赛 T1。

某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
在 words[i] 和 order 中的所有字符都是英文小写字母。

输入 n 个单词，每个单词平均长度为 k
时间复杂度 O(nk)
空间复杂度 O(1)
 */