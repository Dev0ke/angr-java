import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution1585 {
    // 在任意时刻，我们选择操作的子串只要长度为 2 即可
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        Queue<Integer>[] pos = new ArrayDeque[10];
        Arrays.setAll(pos, e -> new ArrayDeque<>());
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - '0'].add(i);
        }
        for (int i = 0; i < n; ++i) {
            int digit = t.charAt(i) - '0';
            if (pos[digit].isEmpty()) {
                return false;
            }
            for (int j = 0; j < digit; j++) {
                if (!pos[j].isEmpty() && pos[j].peek() < pos[digit].peek()) {
                    return false;
                }
            }
            pos[digit].remove();
        }
        return true;
    }
}
/*
1585. 检查字符串是否可以通过排序子字符串得到另一个字符串
https://leetcode.cn/problems/check-if-string-is-transformable-with-substring-sort-operations/description/

给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
- 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
一个 子字符串 定义为一个字符串中连续的若干字符。
提示：
s.length == t.length
1 <= s.length <= 10^5
s 和 t 都只包含数字字符，即 '0' 到 '9' 。

看s中第一个等于t[0]的元素能不能翻山越岭到底第一个位置，如果前面有元素比t[0]小，那么这个元素就是拦路虎，t[0]不可能到底第一个位置
时间复杂度 O(10n)。
 */