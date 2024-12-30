import java.util.HashMap;
import java.util.Map;

public class SolutionP340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        // 双指针
        int l = 0, r = 0;
        int maxLen = 1;
        // key: 窗口最右边字符 value: 对应下标
        Map<Character, Integer> rIdxMap = new HashMap<>();
        while (r < n) {
            if (rIdxMap.size() < k + 1) {
                rIdxMap.put(s.charAt(r), r);
                r++;
            }
            if (rIdxMap.size() == k + 1) {
                int minIdx = Integer.MAX_VALUE;
                for (int idx : rIdxMap.values()) {
                    minIdx = Math.min(minIdx, idx);
                }
                rIdxMap.remove(s.charAt(minIdx));
                l = minIdx + 1;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
/*
$340. 至多包含 K 个不同字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/

给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
提示：
1 <= s.length <= 5 * 10^4
0 <= k <= 50

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
相似題目: $159. 至多包含两个不同字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
 */