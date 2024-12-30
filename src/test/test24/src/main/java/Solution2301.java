import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2301 {
    static class V1 {
        private Map<Character, Set<Character>> mp;

        public boolean matchReplacement(String s, String sub, char[][] mappings) {
            int sLen = s.length();
            int subLen = sub.length();

            mp = new HashMap<>();
            for (char[] p : mappings) {
                // new -> [old]
                mp.computeIfAbsent(p[1], key -> new HashSet<>()).add(p[0]);
            }

            for (int i = 0; i + subLen <= sLen; i++) {
                String subStr = s.substring(i, i + subLen);
                if (check(subStr, sub)) {
                    return true;
                }
            }
            return false;
        }

        private boolean check(String subStr, String sub) {
            for (int j = 0; j < subStr.length(); j++) {
                char newi = subStr.charAt(j);
                char oldi = sub.charAt(j);
                if (newi != oldi) {
                    if (!mp.containsKey(newi) || !mp.get(newi).contains(oldi)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class V2 {
        public boolean matchReplacement(String s, String sub, char[][] mappings) {
            int n = 'z' + 1;
            boolean[][] mp = new boolean[n][n];
            for (char[] p : mappings) {
                mp[p[0]][p[1]] = true;
            }
            for (int i = sub.length(); i <= s.length(); i++) {
                boolean flag = false;
                for (int j = i - sub.length(); j < i; j++) {
                    char c = s.charAt(j);
                    char subj = sub.charAt(j - (i - sub.length()));
                    if (c != subj && !mp[subj][c]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return true;
            }
            return false;
        }
    }
}
/*
2301. 替换字符后匹配
https://leetcode.cn/problems/match-substring-after-replacement/

第 80 场双周赛 T3。

给你两个字符串 s 和 sub 。同时给你一个二维字符数组 mappings ，
其中 mappings[i] = [oldi, newi] 表示你可以替换 sub 中任意数目的 oldi 个字符，替换成 newi 。sub 中每个字符 不能 被替换超过一次。
如果使用 mappings 替换 0 个或者若干个字符，可以将 sub 变成 s 的一个子字符串，请你返回 true，否则返回 false 。
一个 子字符串 是字符串中连续非空的字符序列。
提示：
1 <= sub.length <= s.length <= 5000
0 <= mappings.length <= 1000
mappings[i].length == 2
oldi != newi
s 和 sub 只包含大写和小写英文字母和数字。
oldi 和 newi 是大写、小写字母或者是个数字。

逆向模拟，枚举 s 中的每个子串，判断其是否能是 sub 生成。
时间复杂度 O(n^2)
 */