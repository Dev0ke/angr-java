import java.util.ArrayList;
import java.util.List;

public class SolutionP411 {
    private int n;
    private String target;

    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        this.target = target;

        List<Integer> sameMasks = new ArrayList<>();
        for (String dict : dictionary) {
            // 1、剪枝，长度不一致的不要，并记录二进制 1 相同字母位置
            if (dict.length() != n) {
                continue;
            }
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (target.charAt(i) == dict.charAt(i)) {
                    mask |= (1 << i);
                }
            }
            sameMasks.add(mask);
        }
        // 2、筛选后为空，直接返回 target 长度
        if (sameMasks.isEmpty()) {
            return String.valueOf(n);
        }

        int minLen = n;
        int minMask = (1 << n) - 1;
        for (int mask = 0; mask < (1 << n); mask++) {
            // 3、获取最优情况对应的长度，掩码
            int abbrLen = abbreviationLen(mask);
            if (abbrLen >= minLen) {
                continue;
            }

            boolean flag = false;
            for (int sameMask : sameMasks) {
                // 4、当 mask 是 sameMask 子集时，说明和这个单词形成的结果与原单词一致，不能作为结果
                if ((mask & sameMask) == mask) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }

            minLen = abbrLen;
            minMask = mask;
        }
        // 5、最后再转字符串，优化时间
        return abbreviation(minMask);
    }

    // mask 二进制 0 表示缩写
    private int abbreviationLen(int mask) {
        int cnt = 0;
        int abbrLen = 0;
        for (int k = 0; k < n; k++) {
            if (((mask >> k) & 1) == 0) {
                // 缩写
                cnt++;
            } else {
                if (cnt > 0) {
                    cnt = 0;
                    abbrLen++;
                }
                abbrLen++;
            }
        }
        if (cnt > 0) {
            abbrLen++;
        }
        return abbrLen;
    }

    private String abbreviation(int mask) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int k = 0; k < n; k++) {
            if (((mask >> k) & 1) == 0) {
                // 缩写
                cnt++;
            } else {
                if (cnt > 0) {
                    stringBuilder.append(cnt);
                    cnt = 0;
                }
                stringBuilder.append(target.charAt(k));
            }
        }
        if (cnt > 0) {
            stringBuilder.append(cnt);
        }
        return stringBuilder.toString();
    }
}
/*
$411. 最短独占单词缩写
https://leetcode.cn/problems/minimum-unique-word-abbreviation/

通过将任意数量的 不相邻 子字符串替换为它们的长度，可以完成对字符串的 缩写 。 例如，像 "substitution" 这样的字符串可以缩写为（但不限于）：
- "s10n" ("s ubstitutio n")
- "sub4u4" ("sub stit u tion")
- "12" ("substitution")
- "su3i1u2on" ("su bst i t u ti on")
- "substitution" (不替换子字符串)
注意："s55n" ("s ubsti tutio n") 不是 "substitution" 的有效缩写形式，因为它试图替换两个相邻的子字符串。
缩写的 长度 是未被替换的字母数加上被替换的字符串数。例如，缩写 "s10n" 的长度为 3（2 个字母 + 1 个子字符串），而 "su3i1u2on" 的长度为 9（6 个字母 + 3 子字符串）。
给你一个目标字符串 target 和一个字符串数组 dictionary 作为字典，为 target 找出并返回一个 最短 长度的缩写字符串，同时这个缩写字符串 不是 字典 dictionary 中其他字符串的缩写形式。如果有多个有效答案，可以返回其中任意一个。
提示：
target.length == m
dictionary.length == n
1 <= m <= 21
0 <= n <= 1000
1 <= dictionary[i].length <= 100
如果 n > 0 ，那么 log2(n) + m <= 21
target 和 dictionary[i] 仅包含小写字符

位运算 + 剪枝
java continue label 参考 https://leetcode.cn/problems/minimum-unique-word-abbreviation/solution/yu-niang-niang-411-zui-duan-du-zhan-dan-9ssj0/
相似题目: $320. 列举单词的全部缩写
https://leetcode.cn/problems/generalized-abbreviation/
$408. 有效单词缩写
https://leetcode.cn/problems/valid-word-abbreviation/
 */