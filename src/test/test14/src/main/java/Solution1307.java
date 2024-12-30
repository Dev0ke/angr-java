import java.util.ArrayList;
import java.util.List;

public class Solution1307 {
    private List<PII> weightList;
    private int[] suffix_sum_min, suffix_sum_max;
    private boolean[] lead_zero;
    private boolean[] used;

    static int[] pow10 = new int[8];

    static {
        pow10[0] = 1;
        for (int i = 1; i <= 7; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }

    public boolean isSolvable(String[] words, String result) {
        int[] weight = new int[26];
        lead_zero = new boolean[26];
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                weight[w.charAt(i) - 'A'] += pow10[w.length() - i - 1];
            }
            if (w.length() > 1) lead_zero[w.charAt(0) - 'A'] = true;
        }
        for (int i = 0; i < result.length(); i++) {
            weight[result.charAt(i) - 'A'] -= pow10[result.length() - i - 1];
        }
        if (result.length() > 1) lead_zero[result.charAt(0) - 'A'] = true;

        weightList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (weight[i] == 0) continue;
            weightList.add(new PII(i, weight[i]));
        }
        weightList.sort((o1, o2) -> Integer.compare(Math.abs(o2.wt), Math.abs(o1.wt)));
        int n = weightList.size();
        suffix_sum_min = new int[n];
        suffix_sum_max = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> suffix_pos = new ArrayList<>();
            List<Integer> suffix_neg = new ArrayList<>();
            for (int j = i; j < n; j++) {
                int wt = weightList.get(j).wt;
                if (wt > 0) suffix_pos.add(wt);
                else if (wt < 0) suffix_neg.add(wt);
                suffix_pos.sort(null);
                suffix_neg.sort(null);
            }
            for (int j = 0; j < suffix_pos.size(); j++) {
                suffix_sum_min[i] += (suffix_pos.size() - 1 - j) * suffix_pos.get(j);
                suffix_sum_max[i] += (10 - suffix_pos.size() + j) * suffix_pos.get(j);
            }
            for (int j = 0; j < suffix_neg.size(); j++) {
                suffix_sum_min[i] += (9 - j) * suffix_neg.get(j);
                suffix_sum_max[i] += j * suffix_neg.get(j);
            }
        }
        used = new boolean[10];
        return dfs(0, 0);
    }

    private boolean dfs(int pos, int total) {
        if (pos == weightList.size()) return total == 0;
        if (!(total + suffix_sum_min[pos] <= 0 && 0 <= total + suffix_sum_max[pos])) {
            return false;
        }
        int down = lead_zero[weightList.get(pos).ch] ? 1 : 0;
        for (int i = down; i < 10; ++i) {
            if (used[i]) continue;
            used[i] = true;
            boolean check = dfs(pos + 1, total + weightList.get(pos).wt * i);
            used[i] = false;
            if (check) return true;
        }
        return false;
    }

    static class PII {
        int ch, wt;

        public PII(int ch, int wt) {
            this.ch = ch;
            this.wt = wt;
        }
    }
}
/*
1307. 口算难题
https://leetcode.cn/problems/verbal-arithmetic-puzzle/description/

给你一个方程，左边用 words 表示，右边用 result 表示。
你需要根据以下规则检查方程是否可解：
- 每个字符都会被解码成一位数字（0 - 9）。
- 每对不同的字符必须映射到不同的数字。
- 每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
- 左侧数字之和（words）等于右侧数字（result）。
如果方程可解，返回 True，否则返回 False。
提示：
2 <= words.length <= 5
1 <= words[i].length, results.length <= 7
words[i], result 只含有大写英文字母
表达式中使用的不同字符数最大为 10

权值合并。运行时间约为 2ms。
https://leetcode.cn/problems/verbal-arithmetic-puzzle/solutions/101799/suan-nan-ti-by-leetcode-solution/
 */