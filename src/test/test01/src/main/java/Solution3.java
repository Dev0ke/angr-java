import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, ans = 0;
        Map<Character, Integer> cntMap = new HashMap<>();
        while (r < n) {
            cntMap.merge(s.charAt(r), 1, Integer::sum);
            while (cntMap.get(s.charAt(r)) > 1) {
                cntMap.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
3. 无重复字符的最长子串
https://leetcode.cn/problems/longest-substring-without-repeating-characters/

给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
提示：
0 <= s.length <= 5 * 10^4
s 由英文字母、数字、符号和空格组成

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
相似题目: LCR 167. 招式拆解 I
https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */