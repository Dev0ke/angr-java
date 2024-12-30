import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1157 {
    static class MajorityChecker {
        public MajorityChecker(int[] arr) {
            idx = 0;
            Arrays.setAll(tr, e -> new Node());
            Arrays.fill(root, 0);
            int n = arr.length;
            nums = Arrays.stream(arr).distinct().sorted().boxed().toList();
            root[0] = build(0, nums.size() - 1);
            for (int i = 1; i <= n; i++) {
                // 插入一个数，形成一个新版本的主席树
                root[i] = insert(root[i - 1], 0, nums.size() - 1, find(arr[i - 1]));
                val2pos.computeIfAbsent(arr[i - 1], e -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            int k = (right - left) >> 1;
            ++left;
            ++right;
            int query = query(root[right], root[left - 1], 0, nums.size() - 1, k + 1);
            int mode = nums.get(query);
            List<Integer> pos = val2pos.get(mode);
            int l = lowerBound(pos, left);
            if (l == pos.size()) return -1;
            int r = upperBound(pos, right);
            return r - l >= threshold ? mode : -1;
        }

        private int lowerBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) >= key) r = m;
                else l = m + 1;
            }
            return l;
        }

        private int upperBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) > key) r = m;
                else l = m + 1;
            }
            return l;
        }

        static class Node {
            int l, r; // 左右孩子的rank
            int cnt; // rank属于[l,r]的数有多少个

            public Node() {
            }

            public Node(Node x) {
                this.l = x.l;
                this.r = x.r;
                this.cnt = x.cnt;
            }
        }

        final int N = 20010;
        Node[] tr = new Node[N * 4 + N * 17];
        int idx;
        int[] root = new int[N]; // 原始数组，n个版本的根节点
        List<Integer> nums; // 原数组去重后的有序数组
        Map<Integer, List<Integer>> val2pos = new HashMap<>();

        int build(int l, int r) {
            int cur = ++idx;
            if (l == r) return cur;
            int mid = l + ((r - l) >> 1);
            tr[cur].l = build(l, mid);
            tr[cur].r = build(mid + 1, r);
            return cur;
        }

        int insert(int last, int l, int r, int x) {
            int cur = ++idx;    // 新节点
            tr[cur] = new Node(tr[last]);
            // 叶子节点直接增加计数
            if (l == r) {
                tr[cur].cnt++;
                return cur;
            }
            int mid = l + ((r - l) >> 1);
            if (x <= mid) tr[cur].l = insert(tr[last].l, l, mid, x);    // 往左子树插
            else tr[cur].r = insert(tr[last].r, mid + 1, r, x);        // 往右子树插
            tr[cur].cnt = tr[tr[cur].l].cnt + tr[tr[cur].r].cnt;
            return cur;
        }

        int query(int cur, int last, int l, int r, int k) {
            if (l == r) return l;
            int cnt = tr[tr[cur].l].cnt - tr[tr[last].l].cnt;
            int mid = (l + r) >> 1;
            if (cnt >= k) {
                return query(tr[cur].l, tr[last].l, l, mid, k);
            } else {
                return query(tr[cur].r, tr[last].r, mid + 1, r, k - cnt);
            }
        }

        int find(int x) {
            return lowerBound(nums, x);
        }
    }
}
/*
1157. 子数组中占绝大多数的元素
https://leetcode.cn/problems/online-majority-element-in-subarray/description/

设计一个数据结构，有效地找到给定子数组的 多数元素 。
子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。
实现 MajorityChecker 类:
MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。
int query(int left, int right, int threshold) 返回子数组中的元素  arr[left...right] 至少出现 threshold 次数，如果不存在这样的元素则返回 -1。
提示：
1 <= arr.length <= 2 * 10^4
1 <= arr[i] <= 2 * 10^4
0 <= left <= right < arr.length
threshold <= right - left + 1
2 * threshold > right - left + 1
调用 query 的次数最多为 10^4

主席树。
https://leetcode.cn/problems/online-majority-element-in-subarray/solutions/2228536/zi-shu-zu-zhong-zhan-jue-da-duo-shu-de-y-k1we/comments/1991710
 */