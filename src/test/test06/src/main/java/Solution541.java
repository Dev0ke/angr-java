public class Solution541 {
    public String reverseStr(String s, int k) {
        int len = s.length();

        int k2 = k * 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder preK = new StringBuilder();
        for (int i = 0; i < len; i += k) {
            String subStr = s.substring(i, Math.min(len, i + k));
            if (i % k2 < k) {
                preK.append(subStr);
            } else {
                if (!preK.isEmpty()) {
                    stringBuilder.append(preK.reverse());
                    preK.delete(0, k);
                }
                stringBuilder.append(subStr);
            }
        }
        if (!preK.isEmpty()) {
            stringBuilder.append(preK.reverse());
        }
        return stringBuilder.toString();
    }
}
/*
541. 反转字符串 II
https://leetcode.cn/problems/reverse-string-ii/

给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
- 如果剩余字符少于 k 个，则将剩余字符全部反转。
- 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
提示：
1 <= s.length <= 10^4
s 仅由小写英文组成
1 <= k <= 10^4

按 k*2 取模模拟即可。
 */