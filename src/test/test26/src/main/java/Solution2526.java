public class Solution2526 {
    static class DataStream {
        private final int value;
        private final int k;
        private int sz;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
            sz = 0;
        }

        public boolean consec(int num) {
            if (num == value) {
                sz++;
            } else {
                sz = 0;
            }
            return sz >= k;
        }
    }
}
/*
2526. 找到数据流中的连续整数
https://leetcode.cn/problems/find-consecutive-integers-from-a-data-stream/

第 95 场双周赛 T2。

给你一个整数数据流，请你实现一个数据结构，检查数据流中最后 k 个整数是否 等于 给定值 value 。
请你实现 DataStream 类：
- DataStream(int value, int k) 用两个整数 value 和 k 初始化一个空的整数数据流。
- boolean consec(int num) 将 num 添加到整数数据流。如果后 k 个整数都等于 value ，返回 true ，否则返回 false 。如果少于 k 个整数，条件不满足，所以也返回 false 。
提示：
1 <= value, num <= 10^9
1 <= k <= 10^5
至多调用 consec 次数为 10^5 次。

计数
 */