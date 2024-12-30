import java.util.HashMap;
import java.util.Map;

public class Solution911 {
    static class TopVotedCandidate {
        private final int[] times;
        // 领先者
        private final int[] leading;
        // 统计票数
        private final Map<Integer, Integer> cntMap;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;

            // times.length == persons.length
            int len = persons.length;
            leading = new int[len];
            cntMap = new HashMap<>();
            int max = 0;
            for (int i = 0; i < len; i++) {
                int nextVal = cntMap.getOrDefault(persons[i], 0) + 1;
                cntMap.put(persons[i], nextVal);
                // 在平局的情况下，最近获得投票的候选人将会获胜。
                if (nextVal >= max) {
                    max = nextVal;
                    leading[i] = persons[i];
                } else {
                    leading[i] = leading[i - 1];
                }
            }
        }

        public int q(int t) {
            int left = 1;
            int right = times.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // TTTFFF
                if (times[mid] > t) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return leading[left - 1];
        }
    }
}
/*
911. 在线选举
https://leetcode.cn/problems/online-election/

第 103 场周赛 T4。

给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
实现 TopVotedCandidate 类：
- TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
- int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
提示：
1 <= persons.length <= 5000
times.length == persons.length
0 <= persons[i] < persons.length
0 <= times[i] <= 10^9
times 是一个严格递增的有序数组
times[0] <= t <= 10^9
每个测试用例最多调用 10^4 次 q

预处理结果，由于 times 并非线性，所以通过二分查找来获得时刻 t 结果。
 */