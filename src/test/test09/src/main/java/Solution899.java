import java.util.Arrays;

public class Solution899 {
    public String orderlyQueue(String s, int _k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (_k == 1) {
            // 最小表示法
            // https://oi-wiki.org/string/minimal-string/
            int k = 0;
            int i = 0;
            int j = 1;
            while (k < n && i < n && j < n) {
                if (chars[(i + k) % n] == chars[(j + k) % n]) {
                    k++;
                } else {
                    if (chars[(i + k) % n] > chars[(j + k) % n]) {
                        i = i + k + 1;
                    } else {
                        j = j + k + 1;
                    }
                    if (i == j) {
                        i++;
                    }
                    k = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
/*
899. 有序队列
https://leetcode.cn/problems/orderly-queue/

给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
提示：
1 <= k <= S.length <= 1000
s 只由小写字母组成。

最小表示法
https://oi-wiki.org/string/minimal-string/
 */