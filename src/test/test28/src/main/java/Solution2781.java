import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        Set<String> forbidSet = new HashSet<>(forbidden);

        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            for (int i = r; i >= Math.max(l, r - 9); i--) {
                String sub = word.substring(i, r + 1);
                if (forbidSet.contains(sub)) {
                    l = i + 1;
                    break;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
2781. 最长合法子字符串的长度
https://leetcode.cn/problems/length-of-the-longest-valid-substring/

第 354 场周赛 T4。

给你一个字符串 word 和一个字符串数组 forbidden 。
如果一个字符串不包含 forbidden 中的任何字符串，我们称这个字符串是 合法 的。
请你返回字符串 word 的一个 最长合法子字符串 的长度。
子字符串 指的是一个字符串中一段连续的字符，它可以为空。
提示：
1 <= word.length <= 10^5
word 只包含小写英文字母。
1 <= forbidden.length <= 10^5
1 <= forbidden[i].length <= 10
forbidden[i] 只包含小写英文字母。

双指针 优化
传统双指针，当区间包含 forbidden 时，left 指针每次 +1 收缩，这样效率比较低，
结合 forbidden[i].length <= 10 这个条件，每次以右端点枚举最多 10 个子串。
如果遇到 forbidden，left 直接一步到位到 i+1 即可。
时间复杂度 O(n)
 */