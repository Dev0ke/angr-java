import java.util.ArrayList;
import java.util.List;

public class SolutionP320 {
    private String word;
    private int n;

    public List<String> generateAbbreviations(String word) {
        this.word = word;
        this.n = word.length();

        List<String> resList = new ArrayList<>();
        // 位运算
        for (int mask = 0; mask < (1 << n); mask++) {
            resList.add(abbreviation(mask));
        }
        return resList;
    }

    // mask 二进制 1 表示缩写，0 表示不缩写
    private String abbreviation(int mask) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int k = 0; k < n; k++) {
            if (((mask >> k) & 1) == 1) {
                // 缩写
                cnt++;
            } else {
                if (cnt > 0) {
                    stringBuilder.append(cnt);
                    cnt = 0;
                }
                stringBuilder.append(word.charAt(k));
            }
        }
        if (cnt > 0) {
            stringBuilder.append(cnt);
        }
        return stringBuilder.toString();
    }
}
/*
$320. 列举单词的全部缩写
https://leetcode.cn/problems/generalized-abbreviation/

单词的 广义缩写词 可以通过下述步骤构造：先取任意数量的 不重叠、不相邻 的子字符串，再用它们各自的长度进行替换。
- 例如，"abcde" 可以缩写为：
  - "a3e"（"bcd" 变为 "3" ）
  - "1bcd1"（"a" 和 "e" 都变为 "1"）
  - "5" ("abcde" 变为 "5")
  - "abcde" (没有子字符串被代替)
- 然而，这些缩写是 无效的 ：
  - "23"（"ab" 变为 "2" ，"cde" 变为 "3" ）是无效的，因为被选择的字符串是相邻的
  - "22de" ("ab" 变为 "2" ， "bc" 变为 "2")  是无效的，因为被选择的字符串是重叠的
给你一个字符串 word ，返回 一个由 word 的所有可能 广义缩写词 组成的列表 。按 任意顺序 返回答案。
提示：
1 <= word.length <= 15
word 仅由小写英文字母组成

位运算
时间复杂度 O(n* 2^n)
 */