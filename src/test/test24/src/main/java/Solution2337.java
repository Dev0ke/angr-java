public class Solution2337 {
    public boolean canChange(String start, String target) {
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();

        int i = 0, j = 0, n = s.length;
        while (i < n && j < n) {
            while (i < n && s[i] == '_') i++;
            while (j < n && t[j] == '_') j++;
            if (i < n && j < n) {
                if (s[i] != t[j]) {
                    return false;
                } else {
                    if ((s[i] == 'L' && i < j) || (s[i] == 'R' && i > j)) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }
        while (i < n && s[i] == '_') i++;
        while (j < n && t[j] == '_') j++;
        return i == n && j == n;
    }
}
/*
2337. 移动片段得到字符串
https://leetcode.cn/problems/move-pieces-to-obtain-a-string/

第 301 场周赛 T3。

给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
- 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
- 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
提示：
n == start.length == target.length
1 <= n <= 10^5
start 和 target 由字符 'L'、'R' 和 '_' 组成

分类讨论。
相似题目: 777. 在LR字符串中交换相邻字符
https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */