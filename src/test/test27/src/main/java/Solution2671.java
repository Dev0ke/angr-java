import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2671 {
    static class FrequencyTracker {
        private final Map<Integer, Integer> cntMap;
        private final Map<Integer, Set<Integer>> freqMap;

        public FrequencyTracker() {
            cntMap = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public void add(int number) {
            cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
            int freq = cntMap.get(number);
            freqMap.getOrDefault(freq - 1, new HashSet<>()).remove(number);
            freqMap.computeIfAbsent(freq, key -> new HashSet<>()).add(number);
        }

        public void deleteOne(int number) {
            if (!cntMap.containsKey(number)) {
                return;
            }
            int freq = cntMap.get(number);
            freqMap.getOrDefault(freq, new HashSet<>()).remove(number);
            freqMap.computeIfAbsent(freq - 1, key -> new HashSet<>()).add(number);
            if (freq == 1) {
                cntMap.remove(number);
            } else {
                cntMap.put(number, freq - 1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return !freqMap.getOrDefault(frequency, new HashSet<>()).isEmpty();
        }
    }
}
/*
2671. 频率跟踪器
https://leetcode.cn/problems/frequency-tracker/

第 344 场周赛 T2。

请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
实现 FrequencyTracker 类：
- FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
- void add(int number)：添加一个 number 到数据结构中。
- void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
- bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
提示：
1 <= number <= 10^5
1 <= frequency <= 10^5
最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10^5 次

双 HashMap 模拟
时间复杂度 O(1)
 */