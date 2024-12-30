public class Solution1702 {
    public String maximumBinaryString(String binary) {
        if (!binary.contains("0")) return binary;
        int n = binary.length();
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (int i = binary.indexOf('0') + 1; i < n; i++) {
            if (s[i] == '1') cnt1++;
        }
        return "1".repeat(n - 1 - cnt1) + "0" + "1".repeat(cnt1);
    }
}
/*
1702. 修改后的最大二进制字符串
https://leetcode.cn/problems/maximum-binary-string-after-change/description/

给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
- 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
  - 比方说， "00010" -> "10010"
- 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
  - 比方说， "00010" -> "00001"
请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
提示：
1 <= binary.length <= 10^5
binary 仅包含 '0' 和 '1' 。

贪心。
https://leetcode.cn/problems/maximum-binary-string-after-change/solutions/2732155/tan-xin-jian-ji-xie-fa-pythonjavacgojsru-szie/
时间复杂度 O(n)
 */