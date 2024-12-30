import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution3245 {
    int n;
    int[] tree1, tree2;
    TreeSet<Integer> st;

    int lb(int x) {
        return x & -x;
    }

    void add(int[] tree, int pos, int val) {
        for (; pos <= n; pos += lb(pos)) tree[pos] += val;
    }

    int query(int[] tree, int pos) {
        int ret = 0;
        for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
        return ret;
    }

    // k = 1 表示往结束点 set 里加入新结束点 pos
    // k = -1 表示从结束点 set 里删除结束点 pos
    // L 和 R 是 pos 左边和右边最近的其它结束点
    void update(int L, int R, int pos, int k) {
        int old = (R - L + n) % n;
        if (old == 0) old = n;
        add(tree1, old, -k);
        add(tree2, old, -k * old);

        int len = (pos - L + n) % n;
        if (len == 0) len = n;
        add(tree1, len, k);
        add(tree2, len, k * len);
        len = (R - pos + n) % n;
        if (len == 0) len = n;
        add(tree1, len, k);
        add(tree2, len, k * len);
    }

    // 往结束点 set 里加入新结束点 pos
    void ins(int pos) {
        if (st.isEmpty()) {
            st.add(pos);
            add(tree1, n, 1);
            add(tree2, n, n);
        } else {
            st.add(pos);
            // 找到左右两个最近的其它结束点
            Integer L = st.lower(pos);
            if (L == null) L = st.last();
            Integer R = st.higher(pos);
            if (R == null) R = st.first();
            update(L, R, pos, 1);
        }
    }

    // 从结束点 set 里删除结束点 pos
    void del(int pos) {
        if (st.size() == 1) {
            st.remove(pos);
            add(tree1, n, -1);
            add(tree2, n, -n);
        } else {
            // 找到左右两个最近的其它结束点
            Integer L = st.lower(pos);
            if (L == null) L = st.last();
            Integer R = st.higher(pos);
            if (R == null) R = st.first();
            st.remove(pos);
            update(L, R, pos, -1);
        }
    }

    public List<Integer> numberOfAlternatingGroups(int[] colors, int[][] queries) {
        n = colors.length;
        tree1 = new int[n + 1];
        tree2 = new int[n + 1];
        st = new TreeSet<>();

        for (int i = 0; i < n; i++) if (colors[i] == colors[(i + 1) % n]) ins(i);

        List<Integer> ans = new ArrayList<>();
        for (int[] qry : queries) {
            if (qry[0] == 1) {
                if (st.isEmpty()) ans.add(n);
                else {
                    // 因为树状数组维护的是小于等于 s 的总和
                    // 要求大于等于 s 的总和，可以转为“所有元素之和，减去小于等于 s - 1 的总和”
                    int sm = query(tree2, n) - query(tree2, qry[1] - 1);
                    int cnt = query(tree1, n) - query(tree1, qry[1] - 1);
                    ans.add(sm - cnt * qry[1] + cnt);
                }
            } else {
                // 修改 idx 的颜色，只影响 idx - 1 和 idx 是否成为结束点
                int idx = qry[1], col = qry[2];
                int prv = (idx - 1 + n) % n, nxt = (idx + 1) % n;
                // 回撤旧情况
                if (colors[prv] == colors[idx]) del(prv);
                if (colors[idx] == colors[nxt]) del(idx);
                // 计算新情况
                colors[idx] = col;
                if (colors[prv] == colors[idx]) ins(prv);
                if (colors[idx] == colors[nxt]) ins(idx);
            }
        }
        return ans;
    }
}
/*
3245. 交替组 III
https://leetcode.cn/problems/alternating-groups-iii/description/

给你一个整数数组 colors 和一个二维整数数组 queries 。colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
- colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
- colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
环中连续若干块瓷砖的颜色如果是 交替 颜色（也就是说这组瓷砖中除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替组。
你需要处理两种类型的查询：
- queries[i] = [1, sizei]，确定大小为sizei的 交替组 的数量。
- queries[i] = [2, indexi, colori]，将colors[indexi]更改为colori。
返回数组 answer，数组中按顺序包含第一种类型查询的结果。
注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。

树状数组
https://leetcode.cn/problems/alternating-groups-iii/solutions/2868457/shu-zhuang-shu-zu-by-tsreaper-j2pg/
@TsReaper
rating 3107 (clist.by)
 */