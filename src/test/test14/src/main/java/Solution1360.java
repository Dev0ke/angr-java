import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution1360 {
    public int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(date1, formatter);
        LocalDate d2 = LocalDate.parse(date2, formatter);
        return (int) Math.abs(d2.toEpochDay() - d1.toEpochDay());
    }
}
/*
1360. 日期之间隔几天
https://leetcode.cn/problems/number-of-days-between-two-dates/description/

请你编写一个程序来计算两个日期之间隔了多少天。
日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
提示：
给定的日期是 1971 年到 2100 年之间的有效日期。

库函数。
Zeller 公式。
 */