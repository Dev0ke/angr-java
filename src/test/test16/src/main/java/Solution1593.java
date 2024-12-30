import java.util.HashSet;
import java.util.Set;

public class Solution1593 {
    private String s;
    private Set<String> set;
    private int ans;

    public int maxUniqueSplit(String s) {
        this.s = s;
        set = new HashSet<>();
        ans = 1;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int split) {
        if (i >= s.length()) {
            ans = Math.max(ans, split);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                dfs(j + 1, split + 1);
                set.remove(sub);
            }
        }
    }
}
/*
1593. 拆分字符串使唯一子字符串的数目最大
https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/description/

给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
注意：子字符串 是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 16
s 仅包含小写英文字母

回溯。
时间复杂度 O(n * 2^n)。
 */