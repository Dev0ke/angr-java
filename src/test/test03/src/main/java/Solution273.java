public class Solution273 {
    private static final String[] SINGLES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] TEENS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                stringBuilder.append(toEnglish(curNum)).append(THOUSANDS[i]).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public String toEnglish(int num) {
        StringBuilder curr = new StringBuilder();
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            curr.append(SINGLES[hundred]).append(" Hundred ");
        }
        int ten = num / 10;
        if (ten >= 2) {
            curr.append(TENS[ten]).append(" ");
            num %= 10;
        }
        if (num > 0 && num < 10) {
            curr.append(SINGLES[num]).append(" ");
        } else if (num >= 10) {
            curr.append(TEENS[num - 10]).append(" ");
        }
        return curr.toString();
    }
}
/*
273. 整数转换英文表示
https://leetcode.cn/problems/integer-to-english-words/

将非负整数 num 转换为其对应的英文表示。
示例 1：
输入：num = 123
输出："One Hundred Twenty Three"
提示：
0 <= num <= 2^31 - 1

递归
没营养的一道题。
 */