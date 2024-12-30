import java.util.Map;
import java.util.TreeMap;

public class Solution732 {
    static class MyCalendarThree {
        private final TreeMap<Integer, Integer> treeMap;

        public MyCalendarThree() {
            treeMap = new TreeMap<>();
        }

        public int book(int start, int end) {
            // diff[i] += inc;
            // diff[j + 1] -= inc;
            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

            int max = 0;
            int cnt = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                cnt += entry.getValue();
                max = Math.max(max, cnt);
            }
            return max;
        }
    }
}
/*
732. 我的日程安排表 III
https://leetcode.cn/problems/my-calendar-iii/

当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
- MyCalendarThree() 初始化对象。
- int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
提示：
0 <= start < end <= 10^9
每个测试用例，调用 book 函数最多不超过 400次

差分。
由于本题 "强制在线"，无法使用 离散化差分，但可以基于差分思想使用有序集合来模拟。如 TreeMap
 */