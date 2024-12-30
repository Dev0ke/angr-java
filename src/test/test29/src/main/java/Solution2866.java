import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2866 {
    // 二分 O(nlogn)
    static class V1 {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            // 前后缀分解
            long[] pre = getPre(maxHeights);
            Collections.reverse(maxHeights);
            long[] suf = getPre(maxHeights);

            int n = maxHeights.size();
            long ans = 0;
            for (int i = 0; i <= n; i++) {
                ans = Math.max(ans, pre[i] + suf[n - i]);
            }
            return ans;
        }

        private long[] getPre(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long[] pre = new long[n + 1];
            List<Integer> a = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = maxHeights.get(i);
                int j = searchInts(a, x);
                if (j == a.size()) {
                    a.add(x);
                    pre[i + 1] = pre[i] + x;
                    map.put(x, i);
                } else {
                    // old -> x
                    Integer old = a.get(j);
                    Integer old_j = map.get(old);
                    pre[i + 1] = pre[old_j] + (long) x * (i - old_j + 1);
                    a.set(j, x);
                    a.subList(j + 1, a.size()).clear();
                    map.put(x, old_j);
                }
            }
            return pre;
        }

        private int searchInts(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) >= key) r = m;
                else l = m + 1;
            }
            return l;
        }
    }

    // 单调栈 O(n)
    static class V2 {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            // 前后缀分解
            long[] pre = getPre2(maxHeights);
            Collections.reverse(maxHeights);
            long[] suf = getPre2(maxHeights);

            int n = maxHeights.size();
            long ans = 0;
            for (int i = 0; i <= n; i++) {
                ans = Math.max(ans, pre[i] + suf[n - i]);
            }
            return ans;
        }

        private long[] getPre2(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long[] pre = new long[n + 1];
            long sum = 0;
            // 单调栈存下标
            Deque<Integer> st = new ArrayDeque<>();
            // 哨兵
            st.push(-1);
            for (int i = 0; i < n; i++) {
                while (st.size() > 1 && maxHeights.get(st.peek()) >= maxHeights.get(i)) {
                    int j = st.pop();
                    // 撤销之前加的
                    sum -= (long) maxHeights.get(j) * (j - st.peek());
                }
                // 全部置 x
                sum += (long) maxHeights.get(i) * (i - st.peek());
                st.push(i);
                pre[i + 1] = sum;
            }
            return pre;
        }
    }
}
/*
2866. 美丽塔 II
https://leetcode.cn/problems/beautiful-towers-ii/

第 364 场周赛 T3。

给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
如果以下条件满足，我们称这些塔是 美丽 的：
1. 1 <= heights[i] <= maxHeights[i]
2. heights 是一个 山状 数组。
如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山状 数组：
- 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
- 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
提示：
1 <= n == maxHeights <= 10^5
1 <= maxHeights[i] <= 10^9

范围扩大到 1e5 不能再暴力
前后缀分解
时间复杂度 O(n)
相似题目: 1504. 统计全 1 子矩形
https://leetcode.cn/problems/count-submatrices-with-all-ones/description/
 */