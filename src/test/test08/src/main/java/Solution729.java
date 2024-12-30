import java.util.Map;
import java.util.TreeMap;

public class Solution729 {
    static class MyCalendar {
        private final TreeMap<Integer, Integer> events;

        public MyCalendar() {
            events = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if (event != null && event.getValue() > start) {
                return false;
            }
            event = events.ceilingEntry(start);
            if (event != null && event.getKey() < end) {
                return false;
            }
            events.put(start, end);
            return true;
        }
    }
}
/*
729. 我的日程安排表 I
https://leetcode.cn/problems/my-calendar-i/

实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
实现 MyCalendar 类：
- MyCalendar() 初始化日历对象。
- boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
提示：
0 <= start < end <= 10^9
每个测试用例，调用 book 方法的次数最多不超过 1000 次。

TreeMap 的应用
ceilingEntry/ceilingKey 返回键大于或等于给定值的最小映射/键；如果没有则返回 null
floorEntry/floorKey 返回键小于或等于给定值的最小映射/键；如果没有则返回 null
 */