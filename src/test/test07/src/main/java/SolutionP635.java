import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SolutionP635 {
    static class LogSystem {
        private static final long SECOND = 1L;
        private static final long MINUTE = 60 * SECOND;
        private static final long HOUR = 60 * MINUTE;
        private static final long DAY = 24 * HOUR;
        private static final long MONTH = 32 * DAY;
        private static final long YEAR = 13 * MONTH;

        private final TreeMap<Long, Integer> treeMap;

        public LogSystem() {
            treeMap = new TreeMap<>();
        }

        public void put(int id, String timestamp) {
            treeMap.put(timestamp2Long(timestamp, "Second", 0), id);
        }

        public List<Integer> retrieve(String start, String end, String granularity) {
            List<Integer> resList = new ArrayList<>();
            long startLong = timestamp2Long(start, granularity, 0);
            long endLong = timestamp2Long(end, granularity, 1);
            // 左闭右开
            treeMap.subMap(startLong, endLong).forEach((k, v) -> resList.add(v));
            return resList;
        }

        // start=0 真实值 start=1 偏移值
        private long timestamp2Long(String timestamp, String granularity, int start) {
            long res = 0L;
            String[] ts = timestamp.split(":");
            res += Long.parseLong(ts[0]) * YEAR;
            if (granularity.equals("Year")) {
                return res + start * YEAR;
            }
            res += Long.parseLong(ts[1]) * MONTH;
            if (granularity.equals("Month")) {
                return res + start * MONTH;
            }
            res += Long.parseLong(ts[2]) * DAY;
            if (granularity.equals("Day")) {
                return res + start * DAY;
            }
            res += Long.parseLong(ts[3]) * HOUR;
            if (granularity.equals("Hour")) {
                return res + start * HOUR;
            }
            res += Long.parseLong(ts[4]) * MINUTE;
            if (granularity.equals("Minute")) {
                return res + start * MINUTE;
            }
            res += Long.parseLong(ts[5]) * SECOND;
            return res + start * SECOND;
        }
    }
}
/*
$635. 设计日志存储系统
https://leetcode.cn/problems/design-log-storage-system/

你将获得多条日志，每条日志都有唯一的 id 和 timestamp ，
timestamp 是形如 Year:Month:Day:Hour:Minute:Second 的字符串，2017:01:01:23:59:59 ，所有值域都是零填充的十进制数。
实现 LogSystem 类：

LogSystem() 初始化 LogSystem 对象
void put(int id, string timestamp) 给定日志的 id 和 timestamp ，将这个日志存入你的存储系统中。
int[] retrieve(string start, string end, string granularity) 返回在给定时间区间 [start, end] （包含两端）内的所有日志的 id 。
start 、end 和 timestamp 的格式相同，granularity 表示考虑的时间粒度（例如，精确到 Day、Minute 等）。
例如 start = "2017:01:01:23:59:59"、end = "2017:01:02:23:59:59" 且 granularity = "Day"
意味着需要查找从 Jan. 1st 2017 到 Jan. 2nd 2017 范围内的日志，可以忽略日志的 Hour、Minute 和 Second 。
提示：
1 <= id <= 500
2000 <= Year <= 2017
1 <= Month <= 12
1 <= Day <= 31
0 <= Hour <= 23
0 <= Minute, Second <= 59
granularity 是这些值 ["Year", "Month", "Day", "Hour", "Minute", "Second"] 之一
最多调用 500 次 put 和 retrieve

TreeMap#subMap 有序集合模拟。
 */