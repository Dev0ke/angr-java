public class Solution423 {
    public String originalDigits(String s) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        // e 0 1 3 5 7 8 9
        // f 4 5
        // g 8
        // h 3 8
        // i 5 6 8 9
        // n 1 7 9
        // o 0 1 2 4
        // r 0 3 4
        // s 6 7
        // t 2 3 8
        // u 4
        // v 5 7
        // w 2
        // x 6
        // z 0
        int[] cnt = new int[10];
        cnt[0] = cntArr['z' - 'a'];
        cnt[2] = cntArr['w' - 'a'];
        cnt[4] = cntArr['u' - 'a'];
        cnt[6] = cntArr['x' - 'a'];
        cnt[8] = cntArr['g' - 'a'];

        cnt[3] = cntArr['h' - 'a'] - cnt[8];
        cnt[5] = cntArr['f' - 'a'] - cnt[4];
        cnt[7] = cntArr['s' - 'a'] - cnt[6];

        cnt[1] = cntArr['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = cntArr['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String s1 = String.valueOf((char) (i + '0'));
            ans.append(s1.repeat(cnt[i]));
        }
        return ans.toString();
    }
}
/*
423. 从英文中重建数字
https://leetcode.cn/problems/reconstruct-original-digits-from-english/

给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
提示：
1 <= s.length <= 10^5
s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
s 保证是一个符合题目要求的字符串

推导、找规律题
 */