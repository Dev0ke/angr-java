public class Solution848 {
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        // 反向前缀和
        long[] rePreSum = new long[len];
        rePreSum[len - 1] = shifts[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rePreSum[i] = shifts[i] + rePreSum[i + 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = (char) ((s.charAt(i) - 'a' + rePreSum[i]) % 26 + 'a');
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
/*
848. 字母移位
https://leetcode.cn/problems/shifting-letters/

第 88 场周赛 T1。

有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
- 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
返回将所有这些移位都应用到 S 后最终得到的字符串。
提示:
1 <= s.length <= 10^5
s 由小写英文字母组成
shifts.length == s.length
0 <= shifts[i] <= 10^9

最后的字母移位次数最少，而最前面的字母却是所有次数之和。
类前缀和，可以构造出反向前缀和。根据题意进行模拟即可。
注意 int[] 的前缀和数组会溢出，需用 long[]
 */