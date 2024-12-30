import java.util.Map;
import java.util.TreeMap;

public class Solution352 {
    static class SummaryRanges {
        private final TreeMap<Integer, Integer> leftRightMap;

        public SummaryRanges() {
            leftRightMap = new TreeMap<>();
        }

        public void addNum(int val) {
            // [lr0.getKey(), lr0.getValue()]     [lr1.getKey(), lr1.getValue()]
            // ---------------^ case1
            // ------------------------------^ case2
            // ----------------------------------^ case3
            // ------------------------------^^^^^ case4 (case2 && case3)
            // --------------------------------^ case 5
            Map.Entry<Integer, Integer> lr0 = leftRightMap.floorEntry(val);
            Map.Entry<Integer, Integer> lr1 = leftRightMap.ceilingEntry(val + 1);

            if (lr0 != null && val <= lr0.getValue()) {
                // 省略 && val >= lr0.getKey()
                // case1
            } else {
                boolean byLeft = (lr0 != null) && val == lr0.getValue() + 1;
                boolean byRight = (lr1 != null) && val == lr1.getKey() - 1;
                if (byLeft && byRight) {
                    // case4
                    // 合并两区间
                    int left = lr0.getKey();
                    int right = lr1.getValue();
                    leftRightMap.remove(lr0.getKey());
                    leftRightMap.remove(lr1.getKey());
                    leftRightMap.put(left, right);
                } else if (byLeft) {
                    // case2
                    // 右边界+1
                    leftRightMap.put(lr0.getKey(), lr0.getValue() + 1);
                } else if (byRight) {
                    // case3
                    // 左边界-1
                    int right = lr1.getValue();
                    leftRightMap.remove(lr1.getKey());
                    leftRightMap.put(val, right);
                } else {
                    // case5
                    // 增加区间
                    leftRightMap.put(val, val);
                }
            }
        }

        public int[][] getIntervals() {
            int size = leftRightMap.size();
            int[][] res = new int[size][2];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : leftRightMap.entrySet()) {
                res[idx] = new int[]{entry.getKey(), entry.getValue()};
                idx++;
            }
            return res;
        }
    }
}
/*
352. 将数据流变为多个不相交区间
https://leetcode.cn/problems/data-stream-as-disjoint-intervals/

给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
实现 SummaryRanges 类：
- SummaryRanges() 使用一个空数据流初始化对象。
- void addNum(int val) 向数据流中加入整数 val 。
- int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
提示：
0 <= val <= 10^4
最多调用 addNum 和 getIntervals 方法 3 * 10^4 次
进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?

TreeMap 有序集合分类讨论。
 */