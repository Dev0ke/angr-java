public class Solution2516 {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        if (k == 0) return 0;
        int[] cnt_abc = new int[3];
        for (int i = 0; i < n; i++) {
            cnt_abc[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            cnt_abc[i] -= k;
            if (cnt_abc[i] < 0) return -1;
        }

        int[] cnt_window = new int[n];
        int l = 0, r = 0, maxLen = -1;
        while (r < n) {
            int rIdx = s.charAt(r) - 'a';
            cnt_window[rIdx]++;
            while (cnt_window[rIdx] > cnt_abc[rIdx]) {
                cnt_window[s.charAt(l) - 'a']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return n - maxLen;
    }
}
/*
2516. 每种字符至少取 K 个
https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/

第 325 场周赛 T2。

给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
提示：
1 <= s.length <= 10^5
s 仅由字母 'a'、'b'、'c' 组成
0 <= k <= s.length

不定长滑动窗口（求最长/最大）。
时间复杂度 O(nlogn)
相似题目: 1423. 可获得的最大点数
https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 */