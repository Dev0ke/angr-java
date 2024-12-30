public class Solution171 {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();

        int number = 0;
        int multiple = 1;
        for (int i = len - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}
/*
171. Excel 表列序号
https://leetcode.cn/problems/excel-sheet-column-number/

给你一个字符串  columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号  。
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
1 <= columnTitle.length <= 7
columnTitle 仅由大写英文组成
columnTitle 在范围 ["A", "FXSHRXW"] 内

模拟。
相似题目: 168. Excel表列名称
https://leetcode.cn/problems/excel-sheet-column-title/
 */