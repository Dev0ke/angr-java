import java.util.HashMap;
import java.util.Map;

public class Solution1396 {
    static class UndergroundSystem {
        // id, station, t
        private final Map<Integer, Node> customerMap;
        // in-out, [sum, cnt]
        private final Map<String, int[]> inOutMap;

        public UndergroundSystem() {
            customerMap = new HashMap<>();
            inOutMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            customerMap.put(id, new Node(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Node pre = customerMap.get(id);
            String key = pre.stationName + "-" + stationName;
            int[] val = inOutMap.getOrDefault(key, new int[2]);
            val[0] += t - pre.t;
            val[1]++;
            inOutMap.put(key, val);
            customerMap.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            int[] val = inOutMap.get(key);
            return val[0] / (double) val[1];
        }

        private static class Node {
            String stationName;
            int t;

            public Node(String stationName, int t) {
                this.stationName = stationName;
                this.t = t;
            }
        }
    }
}
/*
1396. 设计地铁系统
https://leetcode.cn/problems/design-underground-system/

地铁系统跟踪不同车站之间的乘客出行时间，并使用这一数据来计算从一站到另一站的平均时间。
实现 UndergroundSystem 类：
- void checkIn(int id, string stationName, int t)
 - 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站进入
 - 乘客一次只能从一个站进入
- void checkOut(int id, string stationName, int t)
 - 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站离开
- double getAverageTime(string startStation, string endStation)
 - 返回从 startStation 站到 endStation 站的平均时间
 - 平均时间会根据截至目前所有从 startStation 站 直接 到达 endStation 站的行程进行计算，也就是从 startStation 站进入并从 endStation 离开的行程
 - 从 startStation 到 endStation 的行程时间与从 endStation 到 startStation 的行程时间可能不同
 - 在调用 getAverageTime 之前，至少有一名乘客从 startStation 站到达 endStation 站
你可以假设对 checkIn 和 checkOut 方法的所有调用都是符合逻辑的。如果一名乘客在时间 t1 进站、时间 t2 出站，那么 t1 < t2 。所有时间都按时间顺序发生。
提示：
1 <= id, t <= 10^6
1 <= stationName.length, startStation.length, endStation.length <= 10 次
所有字符串由大小写英文字母与数字组成
总共最多调用 checkIn、checkOut 和 getAverageTime 方法 2 * 10^4
与标准答案误差在 10^-5 以内的结果都被视为正确结果

HashMap模拟
 */