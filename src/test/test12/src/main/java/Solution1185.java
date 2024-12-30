import java.time.LocalDate;
import java.util.Calendar;

public class Solution1185 {
    private static final String[] WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return WEEK[localDate.getDayOfWeek().getValue() - 1];
    }

    private static final String[] WEEK2 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek2(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return WEEK2[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
/*
1185. 一周中的第几天
https://leetcode.cn/problems/day-of-the-week/

第 153 场周赛 T2。

给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
输入为三个整数：day、month 和 year，分别表示日、月、年。
您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
提示：
给出的日期一定是在 1971 到 2100 年之间的有效日期。

相似题目: 1118. 一月有多少天
https://leetcode.cn/problems/number-of-days-in-a-month/
1154. 一年中的第几天
https://leetcode.cn/problems/day-of-the-year/
 */