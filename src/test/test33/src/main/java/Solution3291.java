public class Solution3291 {
    public int minValidStrings(String[] words, String target) {
        for (String word : words) {
            insert(word);
        }

        // f[i] 表示下标 starti 对应的最长 endi
        int n = target.length();
        int[] f = new int[n];
        for (int st = 0; st < n; st++) {
            int span = search(target, st);
            if (span > 0) {
                f[st] = Math.max(f[st], st + span);
            }
            if (st + span == n) break; // 剪枝
        }

        // 能到达的最远距离下标，当前下标，步数
        int maxR = 0, curR = 0, step = 0;
        // [1, time) 返回所需片段的最小数目
        for (int i = 0; i < n; i++) {
            maxR = Math.max(maxR, f[i]);
            if (i == curR) {
                if (i == maxR) {
                    return -1;
                }
                curR = maxR;
                step++;
            }
        }
        return step;
    }

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
    }

    private final TrieNode root = new TrieNode();

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int j = c - 'a';
            if (node.child[j] == null) {
                node.child[j] = new TrieNode();
            }
            node = node.child[j];
        }
    }

    private int search(String s, int st) {
        TrieNode node = root;
        int span = 0;
        for (int i = st; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (node.child[j] == null) {
                break;
            }
            node = node.child[j];
            span++;
        }
        return span;
    }
}
/*
3291. 形成目标字符串需要的最少字符串数 I
https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i/description/

第 415 场周赛 T3。

给你一个字符串数组 words 和一个字符串 target。
如果字符串 x 是 words 中 任意 字符串的 前缀，则认为 x 是一个 有效 字符串。
现计划通过 连接 有效字符串形成 target ，请你计算并返回需要连接的 最少 字符串数量。如果无法通过这种方式形成 target，则返回 -1。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 5 * 10^3
输入确保 sum(words[i].length) <= 10^5。
words[i] 只包含小写英文字母。
1 <= target.length <= 5 * 10^3
target 只包含小写英文字母。

字典树+跳跃游戏
 */