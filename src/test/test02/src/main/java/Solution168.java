public class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            char ch = (char) (columnNumber % 26 + 'A');
            stringBuilder.append(ch);
            columnNumber /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
/*
168. Excel表列名称
https://leetcode.cn/problems/excel-sheet-column-title/

给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
提示：
1 <= columnNumber <= 2^31 - 1

模拟。
相似题目: 171. Excel 表列序号
https://leetcode.cn/problems/excel-sheet-column-number/
 */