public class Solution307 {
    static class NumArray {
        private final Fenwick fenwick;

        public NumArray(int[] nums) {
            fenwick = new Fenwick(nums);
        }

        public void update(int index, int val) {
            int add = val - fenwick.getSum(index, index);
            fenwick.add(index + 1, add);
        }

        public int sumRange(int left, int right) {
            return fenwick.getSum(left, right);
        }

        private static class Fenwick {
            private final int n;
            private final int[] tree;

            public Fenwick(int n) {
                this.n = n;
                this.tree = new int[n + 1];
            }

            // O(n) 建树
            public Fenwick(int[] nums) {
                this.n = nums.length;
                this.tree = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    tree[i] += nums[i - 1];
                    int j = i + lowbit(i);
                    if (j <= n) {
                        tree[j] += tree[i];
                    }
                }
            }

            int lowbit(int x) {
                return x & -x;
            }

            // nums[x] add k
            void add(int x, int k) {
                while (x <= n) {
                    tree[x] += k;
                    x += lowbit(x);
                }
            }

            // nums [1,x] 的和
            int getSum(int x) {
                int ans = 0;
                while (x > 0) {
                    ans += tree[x];
                    x -= lowbit(x);
                }
                return ans;
            }

            // nums [l,r] 的和
            int getSum(int l, int r) {
                return getSum(r + 1) - getSum(l);
            }
        }
    }

    // 108ms
    static class NumArray2 {
        private final SegTreeUpd seg;

        public NumArray2(int[] nums) {
            seg = new SegTreeUpd(nums);
        }

        public void update(int index, int val) {
            seg.update(index + 1, index + 1, val);
        }

        public int sumRange(int left, int right) {
            return seg.getSum(left + 1, right + 1);
        }

        static class SegTreeUpd {
            int n;
            int[] tree, lazy;
            int[] nums;

            public SegTreeUpd(int[] nums) {
                this.n = nums.length;
                this.tree = new int[4 * n];
                this.lazy = new int[4 * n];

                this.nums = nums;
                build(1, 1, n);
            }

            void build(int p, int l, int r) {
                if (l == r) {
                    tree[p] = nums[l - 1];
                    return;
                }
                int mid = l + (r - l) / 2;
                build(p << 1, l, mid);
                build(p << 1 | 1, mid + 1, r);
                pushUp(p);
            }

            void update(int ql, int qr, int val) {
                update(1, 1, n, ql, qr, val);
            }

            void update(int p, int l, int r, int ql, int qr, int val) {
                if (ql <= l && r <= qr) {
                    tree[p] = val * (r - l + 1);
                    lazy[p] = val;
                    return;
                }
                pushDown(p, l, r);
                int mid = l + (r - l) / 2;
                if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
                if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
                pushUp(p);
            }

            int getSum(int ql, int qr) {
                return getSum(1, 1, n, ql, qr);
            }

            int getSum(int p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return tree[p];
                }
                pushDown(p, l, r);
                int mid = l + (r - l) / 2;
                int sum = 0;
                if (ql <= mid) sum += getSum(p << 1, l, mid, ql, qr);
                if (qr > mid) sum += getSum(p << 1 | 1, mid + 1, r, ql, qr);
                return sum;
            }

            void pushDown(int p, int l, int r) {
                if (lazy[p] != 0) {
                    int mid = l + (r - l) / 2;
                    tree[p << 1] = lazy[p] * (mid - l + 1);
                    tree[p << 1 | 1] = lazy[p] * (r - mid);
                    lazy[p << 1] = lazy[p];
                    lazy[p << 1 | 1] = lazy[p];
                    lazy[p] = 0;
                }
            }

            void pushUp(int p) {
                tree[p] = tree[p << 1] + tree[p << 1 | 1];
            }
        }
    }
}
/*
307. 区域和检索 - 数组可修改
https://leetcode.cn/problems/range-sum-query-mutable/

给你一个数组 nums ，请你完成两类查询。
1.其中一类查询要求 更新 数组 nums 下标对应的值
2.另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
实现 NumArray 类：
- NumArray(int[] nums) 用整数数组 nums 初始化对象
- void update(int index, int val) 将 nums[index] 的值 更新 为 val
- int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
提示：

1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
调用 pdate 和 sumRange 方法次数不大于 3 * 10^4

树状数组/线段树
 */