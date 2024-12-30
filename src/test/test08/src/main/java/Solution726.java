import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution726 {
    private int i;
    private char[] s;

    public String countOfAtoms(String formula) {
        i = 0;
        s = formula.toCharArray();

        Deque<Map<String, Integer>> st = new ArrayDeque<>();
        st.push(new HashMap<>());
        while (i < s.length) {
            char ch = s[i];
            if (ch == '(') {
                i++;
                st.push(new HashMap<>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
            } else if (ch == ')') {
                i++;
                int num = parseNum(); // 括号右侧数字
                Map<String, Integer> popMap = st.pop(); // 弹出括号内的原子数量
                Map<String, Integer> topMap = st.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.merge(atom, v * num, Integer::sum); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = st.peek();
                topMap.merge(atom, num, Integer::sum); // 统计原子数量
            }
        }

        Map<String, Integer> map = st.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(s[i]); // 扫描首字母
        for (i++; i < s.length && Character.isLowerCase(s[i]); i++) {
            sb.append(s[i]); // 扫描首字母后的小写字母
        }
        return sb.toString();
    }

    private int parseNum() {
        if (i == s.length || !Character.isDigit(s[i])) {
            return 1; // 不是数字，视作 1
        }
        int num = 0;
        for (; i < s.length && Character.isDigit(s[i]); i++) {
            num = num * 10 + (s[i] - '0'); // 扫描数字
        }
        return num;
    }
}
/*
726. 原子的数量
https://leetcode.cn/problems/number-of-atoms/description/

给你一个字符串化学式 formula ，返回 每种原子的数量 。
原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。
如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。
- 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。
两个化学式连在一起可以构成新的化学式。
- 例如 "H2O2He3Mg4" 也是化学式。
由括号括起的化学式并佐以数字（可选择性添加）也是化学式。
- 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。
返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
提示：
1 <= formula.length <= 1000
formula 由英文字母、数字、'(' 和 ')' 组成
formula 总是有效的化学式

栈 + 哈希表。
时间复杂度 O(n^2 + nlogn)。
相似题目: 227. 基本计算器 II
https://leetcode.cn/problems/basic-calculator-ii/
 */