public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
/*
796. 旋转字符串
https://leetcode.cn/problems/rotate-string/

给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
提示:
1 <= s.length, goal.length <= 100
s 和 goal 由小写英文字母组成

同 循环数组 判断
 */