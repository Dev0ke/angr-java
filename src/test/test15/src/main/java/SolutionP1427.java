public class SolutionP1427 {
    public String stringShift(String s, int[][] shift) {
        int len = s.length();

        int cnt = 0;
        for (int[] ints : shift) {
            if (ints[0] == 0) {
                cnt -= ints[1];
            } else {
                cnt += ints[1];
            }
        }
        // 避免取余负值
        cnt = ((cnt % len) + len) % len;
        String left = s.substring(len - cnt);
        String right = s.substring(0, len - cnt);
        return left + right;
    }
}
/*
$1427. 字符串的左右移
https://leetcode.cn/problems/perform-string-shifts/

给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，其中 shift[i] = [direction, amount]：
- direction 可以为 0 （表示左移）或 1 （表示右移）。
- amount 表示 s 左右移的位数。
- 左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
- 类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
对这个字符串进行所有操作后，返回最终结果。
提示：
1 <= s.length <= 100
s 只包含小写英文字母
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100

模拟取余。
 */