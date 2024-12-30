public class Solution1694 {
    public String reformatNumber(String number) {
        // 首先，删除 所有的空格和破折号。
        number = number.replace(" ", "").replace("-", "");
        int len = number.length();
        // 特判
        if (len == 2) {
            return number;
        }

        int remain = len % 3;
        int part = len / 3;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < part - 1; i++) {
            stringBuilder.append(number.substring(i * 3, i * 3 + 3)).append("-");
        }
        if (remain == 0) {
            // +3
            stringBuilder.append(number.substring(part * 3 - 3));
        } else if (remain == 1) {
            // +3+1
            stringBuilder.append(number.substring(part * 3 - 3, part * 3 - 3 + 2))
                    .append("-")
                    .append(number.substring(part * 3 - 3 + 2));
        } else {
            // +3+2
            stringBuilder.append(number.substring(part * 3 - 3, part * 3))
                    .append("-")
                    .append(number.substring(part * 3));
        }
        return stringBuilder.toString();
    }
}
/*
1694. 重新格式化电话号码
https://leetcode.cn/problems/reformat-phone-number/

给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
请你按下述方式重新格式化电话号码。
- 首先，删除 所有的空格和破折号。
- 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 - 2 个数字：单个含 2 个数字的块。
 - 3 个数字：单个含 3 个数字的块。
 - 4 个数字：两个分别含 2 个数字的块。
最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
返回格式化后的电话号码。
提示：
2 <= number.length <= 100
number 由数字和字符 '-' 及 ' ' 组成。
number 中至少含 2 个数字。

模拟。
 */