import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2982 {
    public int maximumLength(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        Map<Character, List<Integer>> mp = new HashMap<>();
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && cs[i] == cs[i - 1]; i++) {
            }
            mp.computeIfAbsent(cs[st], e -> new ArrayList<>()).add(i - st);
            cnt[cs[st] - 'a'] += i - st;
        }
        int ans = -1;
        for (Map.Entry<Character, List<Integer>> entry : mp.entrySet()) {
            List<Integer> list = entry.getValue();
            list.sort(Comparator.reverseOrder());
            if (cnt[entry.getKey() - 'a'] < 3) continue;

            // top1 三等分
            int res = list.get(0) - 2;
            ans = Math.max(ans, res);
            // top1 二等分 + top2
            if (list.size() >= 2) {
                res = Math.min(list.get(0) - 1, list.get(1));
                ans = Math.max(ans, res);
            }
            // top1 + top2 + top3
            if (list.size() >= 3) {
                res = list.get(2);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}
/*
2982. 找出出现至少三次的最长特殊子字符串 II
https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/description/

第 378 场周赛 T3。

给你一个仅由小写英文字母组成的字符串 s 。
如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
子字符串 是字符串中的一个连续 非空 字符序列。
提示：
3 <= s.length <= 5 * 10^5
s 仅由小写英文字母组成。

分组循环 + 分类讨论
时间复杂度 O(nlogn)
 */