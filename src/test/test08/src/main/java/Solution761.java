import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution761 {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        int cnt = 0;
        int begin = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(begin + 1, i)) + "0");
                    begin = i + 1;
                }
            }
        }

        list.sort(Collections.reverseOrder());
        return String.join("", list);
    }
}
/*
761. 特殊的二进制序列
https://leetcode.cn/problems/special-binary-string/

特殊的二进制序列是具有以下两个性质的二进制序列：
- 0 的数量与 1 的数量相等。
- 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。
（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
说明:
S 的长度不超过 50。
S 保证为一个满足上述定义的特殊 的二进制序列。

分治
时间复杂度 O(n^2)
拓展：复杂度分析：O(n log n)以及O(n)的最小表示法 https://leetcode.cn/problems/special-binary-string/solution/on-log-n-by-hqztrue-nrmw/
相似题目: LCP 80. 生物进化录
https://leetcode.cn/problems/qoQAMX/
 */