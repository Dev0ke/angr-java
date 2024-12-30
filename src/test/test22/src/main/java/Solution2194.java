import java.util.ArrayList;
import java.util.List;

public class Solution2194 {
    public List<String> cellsInRange(String s) {
        char ch0 = s.charAt(0);
        char ch1 = s.charAt(1);
        char ch3 = s.charAt(3);
        char ch4 = s.charAt(4);

        List<String> resList = new ArrayList<>();
        for (char letter = ch0; letter <= ch3; letter++) {
            for (char digit = ch1; digit <= ch4; digit++) {
                resList.add(String.valueOf(letter) + digit);
            }
        }
        return resList;
    }
}
/*
2194. Excel 表中某个范围内的单元格
https://leetcode.cn/problems/cells-in-a-range-on-an-excel-sheet/

第 283 场周赛 T1。

Excel 表中的一个单元格 (r, c) 会以字符串 "<col><row>" 的形式进行表示，其中：
- <col> 即单元格的列号 c 。用英文字母表中的 字母 标识。
 - 例如，第 1 列用 'A' 表示，第 2 列用 'B' 表示，第 3 列用 'C' 表示，以此类推。
- <row> 即单元格的行号 r 。第 r 行就用 整数 r 标识。
给你一个格式为 "<col1><row1>:<col2><row2>" 的字符串 s ，其中 <col1> 表示 c1 列，<row1> 表示 r1 行，<col2> 表示 c2 列，<row2> 表示 r2 行，并满足 r1 <= r2 且 c1 <= c2 。
找出所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格，并以列表形式返回。单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
提示：
s.length == 5
'A' <= s[0] <= s[3] <= 'Z'
'1' <= s[1] <= s[4] <= '9'
s 由大写英文字母、数字、和 ':' 组成

矩阵模拟。
 */