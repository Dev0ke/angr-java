import java.util.HashMap;
import java.util.Map;

public class Solution2949 {
    public long beautifulSubstrings(String s, int k) {
        int n = s.length();
        for (long d = 1; ; d++) {
            if (d * d % (4L * k) == 0) {
                k = (int) d;
                break;
            }
        }
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + (isVowel(s.charAt(i)) ? 1 : -1);
        }

        long ans = 0;
        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            long key = ((long) (i % k) << 17) + ps[i];
            int cnt = mp.getOrDefault(key, 0);
            ans += cnt;
            mp.put(key, cnt + 1);
        }
        return ans;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
/*
2949. 统计美丽子字符串 II
https://leetcode.cn/problems/count-beautiful-substrings-ii/description/

第 373 场周赛 T4。

给你一个字符串 s 和一个正整数 k 。
用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。
如果某个字符串满足以下条件，则称其为 美丽字符串 ：
- vowels == consonants，即元音字母和辅音字母的数量相等。
- (vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。
返回字符串 s 中 非空美丽子字符串 的数量。
子字符串是字符串中的一个连续字符序列。
英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。
英语中的 辅音字母 为除了元音字母之外的所有字母。
提示：
1 <= s.length <= 5 * 10^4
1 <= k <= 1000
s 仅由小写英文字母组成。

1、设子串长度为 L，需要满足 L^2 是 4k 的倍数
2、元音字母个数 = 辅音字母个数。元音看成 1，辅音看成 -1，子数组元素和 = 0
3、前缀和处理子数组元素和
第一个约束 ps[i] == ps[j]
第二个约束 i-j 是 k' 的倍数 pair(i%k', sum[i]) 的出现次数
相似题目: 974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 */