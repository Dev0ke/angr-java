public class Solution3280 {
    public String convertDateToBinary(String date) {
        String[] sp = date.split("-");
        for (int i = 0; i < sp.length; i++) {
            sp[i] = Integer.toBinaryString(Integer.parseInt(sp[i]));
        }
        return String.join("-", sp);
    }
}
/*
3280. 将日期转换为二进制表示
https://leetcode.cn/problems/convert-date-to-binary/description/

第 414 场周赛 T1。

给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。
返回 date 的 二进制 表示。
提示：
date.length == 10
date[4] == date[7] == '-'，其余的 date[i] 都是数字。
输入保证 date 代表一个有效的公历日期，日期范围从 1900 年 1 月 1 日到 2100 年 12 月 31 日（包括这两天）。

模拟。
时间复杂度 O(1)。
外公的手碰到了天空。
 */