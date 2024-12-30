public class Solution1945 {
    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            stringBuilder.append(ch - 'a' + 1);
        }
        s = stringBuilder.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ch : s.toCharArray()) {
                int cur = ch - '0';
                sum += cur;
            }
            s = String.valueOf(sum);
        }
        return Integer.parseInt(s);
    }
}
/*
1945. 字符串转化后的各位数字之和
https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/

第 251 场周赛 T1。

给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。
接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
- 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
- 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
- 转换 #2：17 ➝ 1 + 7 ➝ 8
返回执行上述操作后得到的结果整数。
提示：
1 <= s.length <= 100
1 <= k <= 10
s 由小写英文字母组成

根据题意进行模拟即可。
 */