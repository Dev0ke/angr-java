import java.util.ArrayList;
import java.util.List;

public class Solution816 {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int span = 1; span < n; span++) {
            List<String> lt = getPos(s.substring(0, span));
            if ((lt.isEmpty())) continue;
            List<String> rt = getPos(s.substring(span));
            if ((rt.isEmpty())) continue;

            for (String i : lt) {
                for (String j : rt) {
                    ans.add("(" + i + ", " + j + ")");
                }
            }
        }
        return ans;
    }

    private List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            pos.add(s);
        }
        for (int p = 1; p < s.length(); p++) {
            if ((p != 1 && s.charAt(0) == '0') || (s.charAt(s.length() - 1) == '0')) {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }
}
/*
816. 模糊坐标
https://leetcode.cn/problems/ambiguous-coordinates/description/

我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
提示:
4 <= S.length <= 12.
S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。

枚举
时间复杂度 O(n^3)
空间复杂度 O(n^3)
 */