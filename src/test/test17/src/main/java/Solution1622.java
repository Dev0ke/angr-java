public class Solution1622 {
    static class Fancy {
        static int N = (int) (1e5 + 5);
        SegmentTree seg;
        int sz;

        public Fancy() {
            seg = new SegmentTree(N);
            sz = 0;
        }

        public void append(int val) {
            sz++;
            seg.update(sz, sz, val, 1);
        }

        public void addAll(int inc) {
            if (sz == 0) return;
            seg.update(1, sz, inc, 1);
        }

        public void multAll(int m) {
            if (sz == 0) return;
            seg.update(1, sz, 0, m);
        }

        public int getIndex(int idx) {
            if (idx + 1 > sz) return -1;
            return (int) seg.query(idx + 1, idx + 1);
        }

        static final long MOD = (long) (1e9 + 7);

        static class SegmentTree {
            int n;
            long[] sm, lazy_add, lazy_mul;

            public SegmentTree(int n) {
                this.n = n;
                sm = new long[4 * n];
                lazy_add = new long[4 * n];
                lazy_mul = new long[4 * n];
            }

            void _do(int p, int l, int r, long add, long mul) {
                int sz = r - l + 1;
                // 先乘后加
                if (mul != 1) {
                    sm[p] = sm[p] * mul % MOD;
                    lazy_add[p] = lazy_add[p] * mul % MOD;
                    lazy_mul[p] = lazy_mul[p] * mul % MOD;
                }
                if (add != 0) {
                    sm[p] = (sm[p] + sz * add) % MOD;
                    lazy_add[p] = (lazy_add[p] + add) % MOD;
                }
            }

            long mergeInfo(long a, long b) {
                return (a + b) % MOD;
            }

            void spread(int p, int l, int r) {
                if (lazy_add[p] != 0 || lazy_mul[p] != 1) {
                    int m = (l + r) >> 1;
                    _do(p << 1, l, m, lazy_add[p], lazy_mul[p]);
                    _do(p << 1 | 1, m + 1, r, lazy_add[p], lazy_mul[p]);
                    lazy_add[p] = 0;
                    lazy_mul[p] = 1;
                }
            }

            void maintain(int p) {
                sm[p] = mergeInfo(sm[p << 1], sm[p << 1 | 1]);
            }

            void update(int ql, int qr, long add, long mul) {
                update(1, 1, n, ql, qr, add, mul);
            }

            void update(int p, int l, int r, int ql, int qr, long add, long mul) {
                if (ql <= l && r <= qr) {
                    _do(p, l, r, add, mul);
                    return;
                }
                spread(p, l, r);
                int m = (l + r) >> 1;
                if (ql <= m) update(p << 1, l, m, ql, qr, add, mul);
                if (qr > m) update(p << 1 | 1, m + 1, r, ql, qr, add, mul);
                maintain(p);
            }

            long query(int ql, int qr) {
                return query(1, 1, n, ql, qr);
            }

            long query(int p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return sm[p];
                }
                spread(p, l, r);
                int m = (l + r) >> 1;
                if (qr <= m) return query(p << 1, l, m, ql, qr);
                if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
                return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
            }
        }
    }
}
/*
1622. 奇妙序列
https://leetcode.cn/problems/fancy-sequence/description/

请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
请实现 Fancy 类 ：
- Fancy() 初始化一个空序列对象。
- void append(val) 将整数 val 添加在序列末尾。
- void addAll(inc) 将所有序列中的现有数值都增加 inc 。
- void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
- int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 10^9 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
提示：
1 <= val, inc, m <= 100
0 <= idx <= 10^5
总共最多会有 10^5 次对 append，addAll，multAll 和 getIndex 的调用。

灵神版线段树。先乘后加。
线段树模板，只需要实现 mergeInfo 和 do，其余都是固定的。
mergeInfo 不建议用对象。
https://leetcode.cn/problems/fancy-sequence/solutions/2914805/ling-shen-xian-duan-shu-mo-ban-gojavaxia-o839/
 */