public class Solution2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        // 差分
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            int i = shift[0];
            int j = shift[1];
            int inc = shift[2] == 0 ? -1 : 1;

            diff[i] += inc;
            diff[j + 1] -= inc;
        }
        // 原数组
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cs[i] = (char) ((((cs[i] - 'a') + res[i]) % 26 + 26) % 26 + 'a');
        }
        return new String(cs);
    }
}
/*
2381. 字母移位 II
https://leetcode.cn/problems/shifting-letters-ii/

第 85 场双周赛 T3。

给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。
对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。
类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
请你返回对 s 进行所有移位操作以后得到的最终字符串。
提示：
1 <= s.length, shifts.length <= 5 * 10^4
shifts[i].length == 3
0 <= starti <= endi < s.length
0 <= directioni <= 1
s 只包含小写英文字母。

差分模拟。
时间复杂度 O(n)
 */