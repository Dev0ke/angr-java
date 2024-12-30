import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution895 {
    static class FreqStack {
        // 元素 频次
        private final Map<Integer, Integer> freqMap;
        // 频次 元素栈
        private final Map<Integer, Deque<Integer>> stackMap;
        private int maxFreq;

        public FreqStack() {
            freqMap = new HashMap<>();
            stackMap = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);
            maxFreq = Math.max(maxFreq, freq);
            stackMap.computeIfAbsent(freq, key -> new ArrayDeque<>()).push(val);
        }

        public int pop() {
            int val = stackMap.get(maxFreq).pop();
            freqMap.put(val, freqMap.get(val) - 1);
            if (stackMap.get(maxFreq).size() == 0) {
                maxFreq--;
            }
            return val;
        }
    }
}
/*
895. 最大频率栈
https://leetcode.cn/problems/maximum-frequency-stack/

设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
实现 FreqStack 类:
- FreqStack() 构造一个空的堆栈。
- void push(int val) 将一个整数 val 压入栈顶。
- int pop() 删除并返回堆栈中出现频率最高的元素。
 - 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
提示：
0 <= val <= 10^9
push 和 pop 的操作数不大于 2 * 10^4。
输入保证在调用 pop 之前堆栈中至少有一个元素。

双 HashMap。
相似题目: 2034. 股票价格波动
https://leetcode.cn/problems/stock-price-fluctuation/
 */