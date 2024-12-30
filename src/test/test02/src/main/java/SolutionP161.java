public class SolutionP161 {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int diffLen = Math.abs(sLen - tLen);
        // 长度相差超过 1 无解
        if (diffLen > 1) {
            return false;
        }
        // 长度相差 1 插入或删除
        else if (diffLen == 1) {
            int p1 = 0;
            int p2 = 0;
            int choice = 1;
            while (p1 < sLen && p2 < tLen) {
                if (s.charAt(p1) != t.charAt(p2)) {
                    choice--;
                    if (sLen < tLen) {
                        p2++;
                    } else {
                        p1++;
                    }
                } else {
                    p1++;
                    p2++;
                }
                if (choice < 0) {
                    return false;
                }
            }
        }
        // 长度相等 替换
        else {
            // 编辑距离为 0 不满足
            if (s.equals(t)) {
                return false;
            }
            int choice = 1;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    choice--;
                }
                if (choice < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
$161. 相隔为 1 的编辑距离
https://leetcode.cn/problems/one-edit-distance/

给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
注意：
满足编辑距离等于 1 有三种可能的情形：
- 往 s 中插入一个字符得到 t
- 从 s 中删除一个字符得到 t
- 在 s 中替换一个字符得到 t
提示:
0 <= s.length, t.length <= 10^4
s 和 t 由小写字母，大写字母和数字组成

分类讨论
时间复杂度 O(m + n)
空间复杂度 O(1)
相似题目: 面试题 01.05. 一次编辑
https://leetcode.cn/problems/one-away-lcci/
 */