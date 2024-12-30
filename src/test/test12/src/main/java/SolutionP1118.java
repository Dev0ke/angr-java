import java.time.YearMonth;
import java.util.Calendar;

public class SolutionP1118 {
    public int numberOfDays(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }

    public int numberOfDays2(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }
}
/*
$1118. 一月有多少天
https://leetcode.cn/problems/number-of-days-in-a-month/

第 4 场双周赛 T1。

指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
提示：
1583 <= year <= 2100
1 <= month <= 12

Java 8 Date/Time API
相似题目: 1154. 一年中的第几天
https://leetcode.cn/problems/day-of-the-year/
1185. 一周中的第几天
https://leetcode.cn/problems/day-of-the-week/
 */