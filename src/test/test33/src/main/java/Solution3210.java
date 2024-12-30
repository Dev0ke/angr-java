public class Solution3210 {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k %= n;
        return s.substring(k) + s.substring(0, k);
    }
}
/*
3210. 找出加密后的字符串
https://leetcode.cn/problems/find-the-encrypted-string/description/

第 405 场周赛 T1。

给你一个字符串 s 和一个整数 k。请你使用以下算法加密字符串：
- 对于字符串 s 中的每个字符 c，用字符串中 c 后面的第 k 个字符替换 c（以循环方式）。
返回加密后的字符串。
提示：
1 <= s.length <= 100
1 <= k <= 10^4
s 仅由小写英文字母组成。

容易观察到 答案是 循环左移。
时间复杂度 O(n)。
 */