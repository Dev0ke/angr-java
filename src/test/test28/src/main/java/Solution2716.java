import java.util.HashSet;
import java.util.Set;

public class Solution2716 {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        return set.size();
    }
}
/*
2716. 最小化字符串长度
https://leetcode.cn/problems/minimize-string-length/

第 348 场周赛 T1。

给你一个下标从 0 开始的字符串 s ，重复执行下述操作 任意 次：
- 在字符串中选出一个下标 i ，并使 c 为字符串下标 i 处的字符。并在 i 左侧（如果有）和 右侧（如果有）各 删除 一个距离 i 最近 的字符 c 。
请你通过执行上述操作任意次，使 s 的长度 最小化 。
返回一个表示 最小化 字符串的长度的整数。
提示：
1 <= s.length <= 100
s 仅由小写英文字母组成

读题题。问题等价于统计不同字符个数。
时间复杂度 O(n)
 */