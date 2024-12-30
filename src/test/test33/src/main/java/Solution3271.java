public class Solution3271 {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n / k; i++) {
            int begin = i * k;
            int end = i * k + k;
            int sum = 0;
            for (int j = begin; j < end; j++) {
                sum += s.charAt(j) - 'a';
            }
            char ch = (char) ((sum % 26) + 'a');
            ans.append(ch);
        }
        return ans.toString();
    }
}
/*
3271. 哈希分割字符串
https://leetcode.cn/problems/hash-divided-string/description/

第 138 场双周赛 T2。

给你一个长度为 n 的字符串 s 和一个整数 k ，n 是 k 的 倍数 。你的任务是将字符串 s 哈希为一个长度为 n / k 的新字符串 result 。
首先，将 s 分割成 n / k 个 子字符串 ，每个子字符串的长度都为 k 。然后，将 result 初始化为一个 空 字符串。
我们依次从前往后处理每一个 子字符串 ：
- 一个字符的 哈希值 是它在 字母表 中的下标（也就是 'a' → 0 ，'b' → 1 ，... ，'z' → 25）。
- 将子字符串中字幕的 哈希值 求和。
- 将和对 26 取余，将结果记为 hashedChar 。
- 找到小写字母表中 hashedChar 对应的字符。
- 将该字符添加到 result 的末尾。
返回 result 。
提示：
1 <= k <= 100
k <= s.length <= 1000
s.length 能被 k 整除。
s 只含有小写英文字母。

模拟。
时间复杂度 O(n)。
 */