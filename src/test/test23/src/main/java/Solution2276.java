import java.util.Map;
import java.util.TreeMap;

public class Solution2276 {
    // 73ms
    static class CountIntervals {
        private final TreeMap<Integer, Integer> intervalMap;
        private int cnt;

        public CountIntervals() {
            intervalMap = new TreeMap<>();
            cnt = 0;
        }

        public void add(int left, int right) {
            int newLeft = left;
            int newRight = right;

            Map.Entry<Integer, Integer> interval = intervalMap.floorEntry(right);
            while (interval != null && interval.getValue() >= newLeft) {
                cnt -= interval.getValue() - interval.getKey() + 1;
                newLeft = Math.min(newLeft, interval.getKey());
                newRight = Math.max(newRight, interval.getValue());
                intervalMap.remove(interval.getKey());
                interval = intervalMap.floorEntry(right);
            }
            intervalMap.put(newLeft, newRight);
            cnt += newRight - newLeft + 1;
        }

        public int count() {
            return cnt;
        }
    }

    // 122ms
    static class CountIntervals2 {
        private final DynamicSegTree seg;

        public CountIntervals2() {
            seg = new DynamicSegTree();
        }

        public void add(int left, int right) {
            seg.update(left, right, 1);
        }

        public int count() {
            return seg.getSum();
        }

        // 动态开点线段树
        private static class DynamicSegTree {
            static class Node {
                Node ls, rs;
                int sum, lazy;
            }

            static final int N = (int) 1e9;
            final Node root = new Node();

            void update(int ql, int qr, int val) {
                this.update(root, 1, N, ql, qr, val);
            }

            void update(Node p, int l, int r, int ql, int qr, int val) {
                int len = r - l + 1;
                if (ql <= l && r <= qr) {
                    p.sum = (val == 1) ? len : 0;
                    p.lazy = val;
                    return;
                }
                pushDown(p, len);
                int mid = l + (r - l) / 2;
                if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
                if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
                pushUp(p);
            }

            int getSum() {
                return this.getSum(root, 1, N, 1, N);
            }

            int getSum(Node p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return p.sum;
                }
                pushDown(p, r - l + 1);
                int mid = l + (r - l) / 2;
                int sum = 0;
                if (ql <= mid) sum = getSum(p.ls, l, mid, ql, qr);
                if (qr > mid) sum += getSum(p.rs, mid + 1, r, ql, qr);
                return sum;
            }

            void pushDown(Node p, int len) {
                if (p.ls == null) p.ls = new Node();
                if (p.rs == null) p.rs = new Node();
                if (p.lazy == 0) return;
                // 当 add = -1 代表 removeRange 懒标记，当 add = 1 则代表 addRange 懒标记。
                int add = p.lazy;
                if (add == -1) {
                    p.ls.sum = 0;
                    p.rs.sum = 0;
                } else {
                    p.ls.sum = len - len / 2;
                    p.rs.sum = len / 2;
                }
                p.ls.lazy = add;
                p.rs.lazy = add;
                p.lazy = 0;
            }

            void pushUp(Node p) {
                p.sum = p.ls.sum + p.rs.sum;
            }
        }
    }
}
/*
2276. 统计区间中的整数数目
https://leetcode.cn/problems/count-integers-in-intervals/

第 293 场周赛 T4。

给你区间的 空 集，请你设计并实现满足要求的数据结构：
- 新增：添加一个区间到这个区间集合中。
- 统计：计算出现在 至少一个 区间中的整数个数。
实现 CountIntervals 类：
- CountIntervals() 使用区间的空集初始化对象
- void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
- int count() 返回出现在 至少一个 区间中的整数个数。
注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
提示：
1 <= left <= right <= 10^9
最多调用  add 和 count 方法 总计 10^5 次
调用 count 方法至少一次

TreeMap模拟 or 动态开点线段树
相似题目: 57. 插入区间
https://leetcode.cn/problems/insert-interval/
352. 将数据流变为多个不相交区间
https://leetcode.cn/problems/data-stream-as-disjoint-intervals/
715. Range 模块
https://leetcode.cn/problems/range-module/
 */