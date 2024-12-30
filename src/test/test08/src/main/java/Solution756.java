import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution756 {
    private Map<String, List<String>> trans;
    private Map<String, Boolean> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        trans = new HashMap<>();
        for (String p : allowed) {
            trans.computeIfAbsent(p.substring(0, 2), e -> new ArrayList<>()).add(p.substring(2));
        }
        memo = new HashMap<>();
        return search(bottom, "");
    }

    private boolean search(String a, String b) {
        String key = a + ":" + b;
        if (memo.containsKey(key)) return memo.get(key);
        if (b.length() >= 2) {
            if (!search(b, "")) return Bool(key, false);
        }
        if (a.length() == 2) {
            if (b.isEmpty()) {
                return Bool(key, trans.containsKey(a));
            }
            for (String t : trans.getOrDefault(a, new ArrayList<>())) {
                if (search(b + t, "")) return Bool(key, true);
            }
            return Bool(key, false);
        }
        String sub = a.substring(1);
        for (String t : trans.getOrDefault(a.substring(0, 2), new ArrayList<>())) {
            if (search(sub, b + t)) return Bool(key, true);
        }
        return Bool(key, false);
    }

    // 记忆化搜索
    private boolean Bool(String key, boolean b) {
        memo.put(key, b);
        return b;
    }
}
/*
756. 金字塔转换矩阵
https://leetcode.cn/problems/pyramid-transition-matrix/description/

你正在把积木堆成金字塔。每个块都有一个颜色，用一个字母表示。每一行的块比它下面的行 少一个块 ，并且居中。
为了使金字塔美观，只有特定的 三角形图案 是允许的。一个三角形的图案由 两个块 和叠在上面的 单个块 组成。模式是以三个字母字符串的列表形式 allowed 给出的，其中模式的前两个字符分别表示左右底部块，第三个字符表示顶部块。
- 例如，"ABC" 表示一个三角形图案，其中一个 “C” 块堆叠在一个 'A' 块(左)和一个 'B' 块(右)之上。请注意，这与 "BAC" 不同，"B" 在左下角，"A" 在右下角。
你从底部的一排积木 bottom 开始，作为一个单一的字符串，你 必须 使用作为金字塔的底部。
在给定 bottom 和 allowed 的情况下，如果你能一直构建到金字塔顶部，使金字塔中的 每个三角形图案 都是允许的，则返回 true ，否则返回 false 。
提示：
2 <= bottom.length <= 6
0 <= allowed.length <= 216
allowed[i].length == 3
所有输入字符串中的字母来自集合 {'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 allowed 中所有值都是 唯一的

记忆化搜索。
一个可以炸掉目前几乎所有题解的测试用例，以及可以过的程序 https://leetcode.cn/problems/pyramid-transition-matrix/solutions/911240/yi-ge-ke-yi-zha-diao-mu-qian-ji-hu-suo-y-6rwk/
 */