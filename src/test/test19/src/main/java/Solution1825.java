import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Solution1825 {
    static class MKAverage {
        private final int m;
        private final int k;
        private final Queue<Integer> queue;
        // 分别存储最小 k 个，中间，最大 k 个元素
        private final TreeMap<Integer, Integer> map1, map2, map3;
        // 三个 TreeMap 对应的 size
        private int sz1, sz2, sz3;
        // 容器剩余 m-2k 个元素的和
        private long sum;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            queue = new LinkedList<>();
            map1 = new TreeMap<>();
            map2 = new TreeMap<>();
            map3 = new TreeMap<>();
            sz1 = 0;
            sz2 = 0;
            sz3 = 0;
            sum = 0L;
        }

        public void addElement(int num) {
            queue.add(num);
            if (queue.size() <= m) {
                map2add(num);
                if (queue.size() == m) {
                    while (sz1 < k) {
                        int min = map2.firstKey();
                        map2del(min);
                        map1add(min);
                    }
                    while (sz3 < k) {
                        int max = map2.lastKey();
                        map2del(max);
                        map3add(max);
                    }
                }
                return;
            }

            // q 的元素数目等于 m+1
            if (num < map1.lastKey()) {
                map1add(num);
                int max = map1.lastKey();
                map1del(max);
                map2add(max);
            } else if (num > map3.firstKey()) {
                map3add(num);
                int min = map3.firstKey();
                map3del(min);
                map2add(min);
            } else {
                map2add(num);
            }

            int rm = queue.remove();
            if (map1.containsKey(rm)) {
                map1del(rm);
                int min = map2.firstKey();
                map2del(min);
                map1add(min);
            } else if (map3.containsKey(rm)) {
                map3del(rm);
                int max = map2.lastKey();
                map2del(max);
                map3add(max);
            } else {
                map2del(rm);
            }
        }

        public int calculateMKAverage() {
            if (queue.size() < m) {
                return -1;
            }
            return (int) (sum / (m - k - k));
        }

        // 封装 "原子操作"
        private void map1del(int num) {
            int val = map1.get(num);
            if (val - 1 == 0) {
                map1.remove(num);
            } else {
                map1.put(num, val - 1);
            }
            sz1--;
        }

        private void map2del(int num) {
            int val = map2.get(num);
            if (val - 1 == 0) {
                map2.remove(num);
            } else {
                map2.put(num, val - 1);
            }
            sz2--;
            sum -= num;
        }

        private void map3del(int num) {
            int val = map3.get(num);
            if (val - 1 == 0) {
                map3.remove(num);
            } else {
                map3.put(num, val - 1);
            }
            sz3--;
        }

        private void map1add(int num) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
            sz1++;
        }

        private void map2add(int num) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
            sz2++;
            sum += num;
        }

        private void map3add(int num) {
            map3.put(num, map3.getOrDefault(num, 0) + 1);
            sz3++;
        }
    }
}
/*
1825. 求出 MK 平均值
https://leetcode.cn/problems/finding-mk-average/

给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。
MK 平均值 按照如下步骤计算：
1. 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
2. 从这个容器中删除最小的 k 个数和最大的 k 个数。
3. 计算剩余元素的平均值，并 向下取整到最近的整数 。
请你实现 MKAverage 类：
- MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
- void addElement(int num) 往数据流中插入一个新的元素 num 。
- int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。
提示：
3 <= m <= 10^5
1 <= k*2 < m
1 <= num <= 10^5
addElement 与 calculateMKAverage 总操作次数不超过 10^5 次。

队列 + 三个 TreeMap 模拟
 */