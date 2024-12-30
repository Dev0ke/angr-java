import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP1087 {
    public String[] expand(String s) {
        // 预处理 "{a,b}c{d,e}f" => [[a,b], [c], [d,e], f]
        List<List<Character>> pretreatmentList = new ArrayList<>();
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            List<Character> chList = new ArrayList<>();
            if (s.charAt(idx) == '{') {
                while (s.charAt(idx) != '}') {
                    if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                        chList.add(s.charAt(idx));
                    }
                    idx++;
                }
            } else {
                if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                    chList.add(s.charAt(idx));
                }
            }
            pretreatmentList.add(chList);
            idx++;
        }
        // List<List<Character>> 转 String[][]
        int pretreatmentSize = pretreatmentList.size();
        String[][] pretreatmentArr = new String[pretreatmentSize][];
        for (int i = 0; i < pretreatmentSize; i++) {
            List<Character> chList = pretreatmentList.get(i);
            int chSize = chList.size();
            pretreatmentArr[i] = new String[chSize];
            for (int j = 0; j < chSize; j++) {
                pretreatmentArr[i][j] = String.valueOf(chList.get(j));
            }
        }

        // 笛卡尔积
        String[] res = pretreatmentArr[0];
        for (int i = 1; i < pretreatmentSize; i++) {
            res = getCartesianProduct(res, pretreatmentArr[i]);
        }
        Arrays.sort(res);
        return res;
    }

    private String[] getCartesianProduct(String[] arr1, String[] arr2) {
        int lenTotal = arr1.length * arr2.length;
        String[] resArr = new String[lenTotal];
        for (int i = 0; i < lenTotal; ) {
            for (String ch1 : arr1) {
                for (String ch2 : arr2) {
                    resArr[i] = ch1 + ch2;
                    i++;
                }
            }
        }
        return resArr;
    }
}
/*
$1087. 花括号展开
https://leetcode.cn/problems/brace-expansion/

第 2 场双周赛 T3。

给定一个表示单词列表的字符串 s 。单词中的每个字母都有一个或多个选项。
- 如果有一个选项，则字母按原样表示。
- 如果有多个选项，则用大括号分隔选项。例如,  "{a,b,c}"  表示选项  ["a", "b", "c"]  。
例如，如果  s = "a{b,c}"  ，第一个字符总是 'a' ，但第二个字符可以是 'b' 或 'c' 。原来的列表是 ["ab", "ac"] 。
请你 按字典顺序 ，返回所有以这种方式形成的单词。
提示：
1 <= S.length <= 50
s 由括号 '{}' , ',' 和小写英文字母组成。
s 保证是一个有效的输入。
没有嵌套的大括号。
在一对连续的左括号和右括号内的所有字符都是不同的。

笛卡尔积。
 */