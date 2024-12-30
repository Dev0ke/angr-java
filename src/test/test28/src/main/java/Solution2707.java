import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2707 {
    private int n;
    private Map<Integer, List<Integer>> lrs;
    private int[] memo;

    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        // 预处理出左右端点
        lrs = new HashMap<>();
        for (String dict : dictionary) {
            for (int[] tuple : findLR(s, dict)) {
                int l = tuple[0], r = tuple[1] - 1;
                lrs.computeIfAbsent(l, key -> new ArrayList<>()).add(r);
            }
        }

        // 记忆化搜索
        memo = new int[n];
        Arrays.fill(memo, -1);
        return n - dfs(0);
    }

    private int dfs(int i) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // 不选
        int res = dfs(i + 1);
        // 选
        if (lrs.containsKey(i)) {
            for (Integer r : lrs.get(i)) {
                res = Math.max(res, r - i + 1 + dfs(r + 1));
            }
        }
        return memo[i] = res;
    }

    private List<int[]> findLR(String s, String dict) {
        List<int[]> resList = new ArrayList<>();
        int idx = s.indexOf(dict);
        while (idx != -1) {
            resList.add(new int[]{idx, idx + dict.length()});
            idx = s.indexOf(dict, idx + 1);
        }
        return resList;
    }
}
/*
2707. 字符串中的额外字符
https://leetcode.cn/problems/extra-characters-in-a-string/

第 105 场双周赛 T2。

给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。
s 中可能会有一些 额外的字符 不在任何子字符串中。
请你采取最优策略分割 s ，使剩下的字符 最少 。
提示：
1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] 和 s 只包含小写英文字母。
dictionary 中的单词互不相同。

记忆化搜索。
时间复杂度 O(L + n^3)。其中 L 为 dictionary 所有字符串的长度之和。
 */