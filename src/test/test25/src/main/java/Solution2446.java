public class Solution2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3, 5));
        int end1 = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3, 5));

        int start2 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3, 5));
        int end2 = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3, 5));

        return Math.max(start1, start2) <= Math.min(end1, end2);
    }
}
/*
2446. 判断两个事件是否存在冲突
https://leetcode.cn/problems/determine-if-two-events-have-conflict/

第 316 场周赛 T1。

给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
- event1 = [startTime1, endTime1] 且
- event2 = [startTime2, endTime2]
事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
提示：
evnet1.length == event2.length == 2.
event1[i].length == event2[i].length == 5
startTime1 <= endTime1
startTime2 <= endTime2
所有事件的时间都按照 HH:MM 格式给出

模拟。转化为数值后比较。
 */