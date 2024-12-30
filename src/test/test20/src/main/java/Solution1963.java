import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1963 {
    public int minSwaps(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            }
            // ch == ']' 出栈
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        int sz = stack.size();
        return (sz + 1) / 2;
    }
}
/*
1963. 使字符串平衡的最小交换次数
https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/

第 253 场周赛 T3。

给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
- 字符串是一个空字符串，或者
- 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
- 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
你可以交换 任意 两个下标所对应的括号 任意 次数。
返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
提示：
n == s.length
2 <= n <= 10^6
n 为偶数
s[i] 为'[' 或 ']'
开括号 '[' 的数目为 n / 2 ，闭括号 ']' 的数目也是 n / 2

括号匹配的题型一般可以用栈解决。找规律，统计不能匹配的个数：
    ][     1 次
   ]][[    1 次
  ]]][[[   2 次
 ]]]][[[[  2 次
]]]]][[[[[ 3 次
当不匹配数为偶数时，最小交换次数 = n / 2
当不匹配数为奇数时，最小交换次数 = n / 2 + 1
可直接简化成最小交换次数 = (n + 1) / 2
 */