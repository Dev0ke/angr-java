import java.util.Arrays;
import java.util.TreeSet;

public class Solution1847 {
    // https://leetcode.cn/problems/closest-room/solutions/754916/zui-jin-de-fang-jian-by-leetcode-solutio-9ylf/comments/1649258
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length;
        int q = queries.length;

        Arrays.sort(rooms, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        Integer[] ids = new Integer[q];
        for (int i = 0; i < q; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> Integer.compare(queries[o2][1], queries[o1][1]));

        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        int i = 0;
        for (Integer qId : ids) {
            int preferred = queries[qId][0], minSize = queries[qId][1];

            while (i < n && rooms[i][1] >= minSize) {
                set.add(rooms[i][0]);
                i++;
            }
            Integer floor = set.floor(preferred);
            Integer ceiling = set.ceiling(preferred);
            if (floor == null && ceiling == null) {
                ans[qId] = -1;
            } else if (floor == null || ceiling == null) {
                ans[qId] = floor != null ? floor : ceiling;
            } else {
                ans[qId] = (preferred - floor) <= (ceiling - preferred) ? floor : ceiling;
            }
        }
        return ans;
    }
}
/*
1847. 最近的房间
https://leetcode.cn/problems/closest-room/description/

一个酒店里有 n 个房间，这些房间用二维整数数组 rooms 表示，其中 rooms[i] = [roomIdi, sizei] 表示有一个房间号为 roomIdi 的房间且它的面积为 sizei 。每一个房间号 roomIdi 保证是 独一无二 的。
同时给你 k 个查询，用二维数组 queries 表示，其中 queries[j] = [preferredj, minSizej] 。第 j 个查询的答案是满足如下条件的房间 id ：
- 房间的面积 至少 为 minSizej ，且
- abs(id - preferredj) 的值 最小 ，其中 abs(x) 是 x 的绝对值。
如果差的绝对值有 相等 的，选择 最小 的 id 。如果 没有满足条件的房间 ，答案为 -1 。
请你返回长度为 k 的数组 answer ，其中 answer[j] 为第 j 个查询的结果。
提示：
n == rooms.length
1 <= n <= 10^5
k == queries.length
1 <= k <= 10^4
1 <= roomIdi, preferredj <= 10^7
1 <= sizei, minSizej <= 10^7

离线查询 + 二分查找
 */