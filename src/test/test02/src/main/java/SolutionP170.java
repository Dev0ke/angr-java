import java.util.HashMap;
import java.util.Map;

public class SolutionP170 {
    static class TwoSum {
        private final Map<Integer, Integer> hashMap;

        public TwoSum() {
            hashMap = new HashMap<>();
        }

        public void add(int number) {
            hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int want = value - entry.getKey();
                if (want != entry.getKey()) {
                    if (hashMap.containsKey(want)) {
                        return true;
                    }
                } else {
                    if (entry.getValue() > 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
/*
$170. 两数之和 III - 数据结构设计
https://leetcode.cn/problems/two-sum-iii-data-structure-design/

设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
实现 TwoSum 类：
- TwoSum() 使用空数组初始化 TwoSum 对象
- void add(int number) 向数据结构添加一个数 number
- boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
提示：
-10^5 <= number <= 10^5
-2^31 <= value <= 2^31 - 1
最多调用 10^4 次 add 和 find

HashMap
add() 时间复杂度 O(1)
find() 时间复杂度 O(n)
 */