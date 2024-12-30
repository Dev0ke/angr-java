import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1782 {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        // deg[a] + deg[b] - overlap[a][b] > query
        int[] degrees = new int[n + 1];
        Map<Integer, Integer> overLapMap = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int encode = encode(n, from, to);

            degrees[from]++;
            degrees[to]++;
            overLapMap.put(encode, overLapMap.getOrDefault(encode, 0) + 1);
        }

        int[] sortedDegrees = new int[n + 1];
        System.arraycopy(degrees, 0, sortedDegrees, 0, n + 1);
        Arrays.sort(sortedDegrees);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 先求 deg[a] + deg[b] > query 的数量
            int left = 1;
            int right = n;
            while (left < right) {
                if (sortedDegrees[left] + sortedDegrees[right] > queries[i]) {
                    res[i] += right - left;
                    right--;
                } else {
                    left++;
                }
            }

            // 再减去 deg[a] + deg[b] - overlap[a][b] <= query 的数量
            Set<Integer> visited = new HashSet<>();
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int encode = encode(n, from, to);

                if (degrees[from] + degrees[to] > queries[i]
                        && degrees[from] + degrees[to] - overLapMap.get(encode) <= queries[i]
                        && !visited.contains(encode)) {
                    visited.add(encode);
                    res[i]--;
                }
            }
        }
        return res;
    }

    private int encode(int n, int a, int b) {
        return Math.max(a, b) * (n + 1) + Math.min(a, b);
    }

    public int[] countPairs2(int n, int[][] edges, int[] queries) {
        // 枚举边
        Map<Integer, Set<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            idxMap.computeIfAbsent(from, key -> new HashSet<>()).add(i);
            idxMap.computeIfAbsent(to, key -> new HashSet<>()).add(i);
        }

        List<Integer> cntList = new ArrayList<>();

        // a < b
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                Set<Integer> pre = new HashSet<>(idxMap.getOrDefault(i, new HashSet<>()));
                pre.addAll(idxMap.getOrDefault(j, new HashSet<>()));
                int cnt = pre.size();
                cntList.add(cnt);
            }
        }

        Collections.sort(cntList);

        // Queries
        int resLen = queries.length;
        int[] res = new int[resLen];
        int total = n * (n - 1) / 2;
        for (int i = 0; i < resLen; i++) {
            // 二分
            int left = 0;
            int right = cntList.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (cntList.get(mid) > queries[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = total - left;
        }
        return res;
    }
}
/*
1782. 统计点对的数目
https://leetcode.cn/problems/count-pairs-of-nodes/

给你一个无向图，无向图由整数 n  ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边。同时给你一个代表查询的整数数组 queries 。
第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目：
- a < b
- cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。
请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案。
请注意，图中可能会有 重复边 。
提示：
2 <= n <= 2 * 10^4
1 <= edges.length <= 10^5
1 <= ui, vi <= n
ui != vi
1 <= queries.length <= 20
0 <= queries[j] < edges.length

直接求 deg[a] + deg[b] - overlap[a][b] > query 时间复杂度为 O(n^2) TLE
巧妙转化为 先求 deg[a] + deg[b] > query 的数量，再减去 deg[a] + deg[b] - overlap[a][b] <= query 的数量
时间复杂度 O(nlogn) 为排序时间复杂度
 */