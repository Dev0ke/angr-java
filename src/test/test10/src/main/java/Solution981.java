import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution981 {
    static class TimeMap {
        private final Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> treeMap = map.get(key);
                Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
                if (entry != null) {
                    return entry.getValue();
                }
            }
            return "";
        }
    }
}
/*
981. 基于时间的键值存储
https://leetcode.cn/problems/time-based-key-value-store/

设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
实现 TimeMap 类：
- TimeMap() 初始化数据结构对象
- void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳 timestamp。
- String get(String key, int timestamp)
 - 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
 - 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 - 如果没有值，则返回空字符串（""）。
 提示：
1 <= key.length, value.length <= 100
key 和 value 由小写英文字母和数字组成
1 <= timestamp <= 10^7
set 操作中的时间戳 timestamp 都是严格递增的
最多调用 set 和 get 操作 2 * 10^5 次

使用 TreeMap#floorEntry() 取 对应最大的  timestamp_prev 的那个值
 */