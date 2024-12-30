import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> wordIdxMap = new HashMap<>();
        TreeSet<Integer> lenTreeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            wordIdxMap.put(words[i], i);
            lenTreeSet.add(words[i].length());
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // abc cba 行
            // aba aba 不行
            String reverse = new StringBuilder(words[i]).reverse().toString();
            int j = wordIdxMap.getOrDefault(reverse, i);
            if (j != i) {
                resList.add(List.of(i, j));
            }

            int len = words[i].length();
            for (Integer k : lenTreeSet) {
                if (k == len) break;

                // words[i]=abcd, reverse=dcba, sub=cba
                if (isPal(reverse, 0, len - 1 - k)) {
                    String sub = reverse.substring(len - k);
                    if (wordIdxMap.containsKey(sub)) {
                        resList.add(List.of(i, wordIdxMap.get(sub)));
                    }
                }

                // words[i]=abcd, reverse=dcba, sub=dcb
                if (isPal(reverse, k, len - 1)) {
                    String sub = reverse.substring(0, k);
                    if (wordIdxMap.containsKey(sub)) {
                        resList.add(List.of(wordIdxMap.get(sub), i));
                    }
                }
            }
        }
        return resList;
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // 暴力解法 TLE
    public List<List<Integer>> palindromePairs2(String[] words) {
        int n = words.length;
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (isPal(words[i] + words[j])) {
                    resList.add(List.of(i, j));
                }
            }
        }
        return resList;
    }

    private boolean isPal(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
/*
336. 回文对
https://leetcode.cn/problems/palindrome-pairs/

给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
提示：
1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] 由小写英文字母组成

分类讨论 + 哈希表
1.数组里有空字符串，并且数组里还有自己就是回文的字符串，每出现一个可与空字符串组成两对。
2.如果自己的翻转后的字符串也在数组里，可以组成一对，注意翻转后不能是自己。
3.如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，可组成一对。
4.把 3 反过来，如果后部分是回文，前半部分翻转后在数组里，可组成一对。
 */