public class Solution2384 {
    public String largestPalindromic(String num) {
        int[] cntArr = new int[10];
        for (char ch : num.toCharArray()) {
            cntArr[ch - '0']++;
        }

        int mid = -1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (cntArr[i] % 2 == 1 && mid == -1) {
                mid = i;
            }
            // 不含 前导零
            if (i == 0 && stringBuilder.isEmpty()) {
                if (mid == -1) {
                    mid = 0;
                }
                break;
            }
            int repeat = cntArr[i] / 2;
            stringBuilder.append(String.valueOf(i).repeat(repeat));
        }
        if (mid != -1) {
            return stringBuilder.toString() + mid + stringBuilder.reverse();
        }
        return stringBuilder.toString() + stringBuilder.reverse();
    }
}
/*
2384. 最大回文数字
https://leetcode.cn/problems/largest-palindromic-number/

第 307 场周赛 T2。

给你一个仅由数字（0 - 9）组成的字符串 num 。
请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
注意：
- 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
- 数字可以重新排序。
提示：
1 <= num.length <= 10^5
num 由数字（0 - 9）组成

贪心
时间复杂度 O(n)
 */