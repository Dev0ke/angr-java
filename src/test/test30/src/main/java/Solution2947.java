public class Solution2947 {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int vowels = 0, consonants = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (isVowel(c)) vowels++;
                else consonants++;
                if (vowels == consonants && vowels * consonants % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
/*
2947. 统计美丽子字符串 I
https://leetcode.cn/problems/count-beautiful-substrings-i/description/

第 373 场周赛 T2。

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
1 <= s.length <= 1000
1 <= k <= 1000
s 仅由小写英文字母组成。

暴力，注意不要搞成 O(n^3) 了，会 TLE。。。
时间复杂度 O(n^2)
 */