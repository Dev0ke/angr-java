import java.util.ArrayList;
import java.util.List;

public class Solution3085 {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                a.add(cnt[i]);
            }
        }

        int ans = word.length();
        for (Integer low : a) {
            int up = low + k;
            int del = 0;
            for (Integer y : a) {
                if (y < low) del += y;
                else if (y > up) del += y - up;
            }
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
/*
3085. 成为 K 特殊字符串需要删除的最少字符数
https://leetcode.cn/problems/minimum-deletions-to-make-string-k-special/description/

第 389 场周赛 T3。

给你一个字符串 word 和一个整数 k。
如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。
此处，freq(x) 表示字符 x 在 word 中的出现频率，而 |y| 表示 y 的绝对值。
返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。
提示：
1 <= word.length <= 10^5
0 <= k <= 10^5
word 仅由小写英文字母组成。

枚举上下界，取最小值即可。
时间复杂度 O(n + 26^2)
 */