public class Solution3258 {
    public int countKConstraintSubstrings(String S, int k) {
        int n = S.length();
        char[] s = S.toCharArray();
        int l = 0, r = 0;
        int[] cnt = new int[2];
        int ans = 0;
        while (r < n) {
            cnt[s[r] - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[l] - '0']--;
                l++;
            }
            ans += r - l+1;
            r++;
        }
        return ans;
    }
}
/*
3258. 统计满足 K 约束的子字符串数量 I
https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/

第 411 场周赛 T1。

给你一个 二进制 字符串 s 和一个整数 k。
如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
- 字符串中 0 的数量最多为 k。
- 字符串中 1 的数量最多为 k。
返回一个整数，表示 s 的所有满足 k 约束 的 子字符串 的数量。
提示：
1 <= s.length <= 50
1 <= k <= s.length
s[i] 是 '0' 或 '1'。

双指针。
时间复杂度 O(n)。
 */