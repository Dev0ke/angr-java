public class Solution715 {
    // 135ms
    static class RangeModule {
        private final DynamicSegTree seg;

        public RangeModule() {
            seg = new DynamicSegTree();
        }

        public void addRange(int left, int right) {
            // 半开区间 [left, right)
            seg.update(left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            // 半开区间 [left, right)
            return seg.getSum(left, right - 1) == (right - left);
        }

        public void removeRange(int left, int right) {
            // 半开区间 [left, right)
            seg.update(left, right - 1, -1);
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

            int getSum(int ql, int qr) {
                return this.getSum(root, 1, N, ql, qr);
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
715. Range 模块
https://leetcode.cn/problems/range-module/

Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
实现 RangeModule 类:
- RangeModule() 初始化数据结构的对象。
- void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
- boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
- void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
提示：
1 <= left < right <= 10^9
在单个测试用例中，对 addRange 、  queryRange 和 removeRange 的调用总数不超过 10^4 次

动态开点线段树（动态指针）
相似题目: 2276. 统计区间中的整数数目
https://leetcode.cn/problems/count-integers-in-intervals/
 */