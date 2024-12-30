import java.util.Arrays;

public class Solution1525 {
    public int numSplits(String s) {
        int n = s.length();

        // 前后缀分解 [0,i]
        int[] cnt = new int[26];
        int k = 0;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int b = s.charAt(i) - 'a';
            cnt[b]++;
            if (cnt[b] == 1) {
                k++;
            }
            pre[i] = k;
        }

        // [i,n-1]
        Arrays.fill(cnt, 0);
        k = 0;
        int[] suf = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int b = s.charAt(i) - 'a';
            cnt[b]++;
            if (cnt[b] == 1) {
                k++;
            }
            suf[i] = k;
        }

        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (pre[i] == suf[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
1525. 字符串的好分割数目
https://leetcode.cn/problems/number-of-good-ways-to-split-a-string/description/

给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
请你返回 s 中好分割的数目。
提示：
s 只包含小写英文字母。
1 <= s.length <= 10^5

前后缀分解。
时间复杂度 O(n)
 */