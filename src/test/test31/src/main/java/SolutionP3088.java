import java.util.Arrays;

public class SolutionP3088 {
    public String makeAntiPalindrome(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        // 先排序，前半部分当基准
        Arrays.sort(s);
        int m = n / 2;
        if (s[m] == s[m - 1]) {
            int i = m;
            while (i < n && s[i] == s[i - 1]) {
                i++;
            }

            for (int j = m; j < n && s[j] == s[2 * m - 1 - j]; j++) {
                if (i >= n) {
                    return "-1";
                }
                char tmp = s[j];
                s[j] = s[i];
                s[i] = tmp;
                i++;
            }
        }
        return new String(s);
    }
}
/*
$3088. 使字符串反回文
https://leetcode.cn/problems/make-string-anti-palindrome/description/

我们称一个长度为偶数的字符串 s 为 反回文 的，如果对于每一个下标 0 <= i < n ，s[i] != s[n - i - 1]。
给定一个字符串 s，你需要进行 任意 次（包括 0）操作使 s 成为 反回文。
在一次操作中，你可以选择 s 中的两个字符并且交换它们。
返回结果字符串。如果有多个字符串符合条件，返回 字典序最小 的那个。如果它不能成为一个反回文，返回 "-1"。
提示：
2 <= s.length <= 10^5
s.length % 2 == 0
s 只包含小写英文字母。

从后半段第一个字符开始判断，如果与对应位置字符相同，向右找到第一个不同字符，然后交换。接着判断下一个字符，直到与对应位置字符不同，结束遍历。
https://leetcode.cn/problems/make-string-anti-palindrome/solutions/2699804/zhong-wen-zhan-ci-ti-di-yi-ge-ti-jiao-to-xd0t/
时间复杂度 O(nlogn)。
 */