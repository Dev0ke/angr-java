import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2030 {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int len = s.length();
        // 删除 k 个字符
        k = len - k;

        // 右侧（含自身）letter 频次
        int outCnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                outCnt++;
            }
        }
        // 栈中 letter 频次
        int inCnt = 0;

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                if (stack.peek() == letter) {
                    // 栈顶元素能出栈
                    if (outCnt > repetition) {
                        stack.pop();
                        outCnt--;
                        inCnt--;
                        k--;
                    } else {
                        break;
                    }
                } else {
                    stack.pop();
                    k--;
                }
            }

            stack.push(ch);
            if (ch == letter) {
                inCnt++;
            }
        }

        int trailing = 0;
        while (!stack.isEmpty() && k > 0) {
            if (stack.peek() == letter) {
                if (inCnt > repetition) {
                    k--;
                } else {
                    // 实际上不能删，先标记，后面再补回来
                    trailing++;
                }
                stack.pop();
                inCnt--;
            } else {
                stack.pop();
                k--;
            }
        }

        int sz = stack.size();
        char[] chars = new char[sz];
        for (int i = sz - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return new String(chars) + String.valueOf(letter).repeat(trailing);
    }
}
/*
2030. 含特定字母的最小子序列
https://leetcode.cn/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

第 261 场周赛 T4。

给你一个字符串 s ，一个整数 k ，一个字母 letter 以及另一个整数 repetition 。
返回 s 中长度为 k 且 字典序最小 的子序列，该子序列同时应满足字母 letter 出现 至少 repetition 次。生成的测试用例满足 letter 在 s 中出现 至少 repetition 次。
子序列 是由原字符串删除一些（或不删除）字符且不改变剩余字符顺序得到的剩余字符串。
字符串 a 字典序比字符串 b 小的定义为：在 a 和 b 出现不同字符的第一个位置上，字符串 a 的字符在字母表中的顺序早于字符串 b 的字符。
提示：
1 <= repetition <= k <= s.length <= 5 * 10^4
s 由小写英文字母组成
letter 是一个小写英文字母，在 s 中至少出现 repetition 次

单调栈。
相似题目: 402. 移掉 K 位数字
https://leetcode.cn/problems/remove-k-digits/
1673. 找出最具竞争力的子序列
https://leetcode.cn/problems/find-the-most-competitive-subsequence/
 */