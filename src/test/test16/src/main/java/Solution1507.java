public class Solution1507 {
    public String reformatDate(String date) {
        String[] sp = date.split(" ");
        int year = Integer.parseInt(sp[2]);
        int month = getMonth(sp[1]);
        int day = Integer.parseInt(sp[0].substring(0, sp[0].length() - 2));
        return String.format("%d-%02d-%02d", year, month, day);
    }

    private int getMonth(String m) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            if (m.equals(months[i])) {
                return i + 1;
            }
        }
        return -1;
    }
}
/*
1507. 转变日期格式
https://leetcode.cn/problems/reformat-date/description/

给你一个字符串 date ，它的格式为 Day Month Year ，其中：
- Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
- Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
- Year 的范围在 [1900, 2100] 之间。
请你将字符串转变为 YYYY-MM-DD 的格式，其中：
- YYYY 表示 4 位的年份。
- MM 表示 2 位的月份。
- DD 表示 2 位的天数。

模拟。
时间复杂度 O(1)。
 */