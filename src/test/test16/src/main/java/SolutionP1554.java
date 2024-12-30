import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1554 {
    public boolean differByOne(String[] dict) {
        // self-defined hash, mod 5801, any big prime fine
        // strict, check if there is hash clashing

        int mod = 5801, m = dict[0].length();
        int[] mod_pows = new int[m];
        mod_pows[0] = 1;
        for (int i = 1; i < m; ++i) {
            mod_pows[i] = mod_pows[i - 1] * 27 % mod;
        }

        Map<Integer, List<Integer>> hs = new HashMap<>(); // we can also use deque<int> here

        for (int k = 0; k < dict.length; ++k) {
            int h = 0;
            for (char c : dict[k].toCharArray()) {
                h = (27 * h + c - 'a' + 1) % mod;
            }
            for (int i = 0; i < m; ++i) {
                int t = (h - mod_pows[m - i - 1] * (dict[k].charAt(i) - 'a' + 1) % mod + mod) % mod;
                if (hs.containsKey(t)) {
                    for (int x : hs.get(t)) {
                        int kk = (x / m);
                        int ii = (x % m);
                        if (ii == i) {
                            boolean checked = true;
                            for (int p = 0; p < m; ++p) {
                                if (p == i) continue;
                                if (dict[k].charAt(p) != dict[kk].charAt(p)) {
                                    checked = false;
                                    break;
                                }
                            }
                            if (checked) return true;
                        }
                    }
                }
                hs.computeIfAbsent(t, e -> new ArrayList<>()).add(m * k + i);
            }
        }

        return false;
    }
}
/*
$1554. 只有一个不同字符的字符串
https://leetcode.cn/problems/strings-differ-by-one-character/description/

给定一个字符串列表 dict ，其中所有字符串的长度都相同。
当存在两个字符串在相同索引处只有一个字符不同时，返回 True ，否则返回 False 。
提示：
dict 中的字符数小于或等于 10^5 。
dict[i].length == dict[j].length
dict[i] 是互不相同的。
dict[i] 只包含小写英文字母。
进阶：你可以以 O(n*m) 的复杂度解决问题吗？其中 n 是列表 dict 的长度，m 是字符串的长度。

滚动哈希
https://leetcode.cn/problems/strings-differ-by-one-character/solutions/385966/onmjie-fa-zi-ding-yi-hashhan-shu-by-orangezeit/
时间复杂度 O(n*m)。
 */