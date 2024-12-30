import java.util.Arrays;

public class Solution1601 {
    public int maximumRequests(int n, int[][] requests) {
        int len = requests.length;
        int[] expected = new int[n];

        int max = 0;
        // 状态压缩 dp
        for (int state = 0; state < (1 << len); state++) {
            int bitCount = Integer.bitCount(state);
            if (bitCount < max) {
                continue;
            }

            int[] degrees = new int[n];

            for (int k = 0; k < len; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    int from = requests[k][0];
                    int to = requests[k][1];

                    degrees[from]--;
                    degrees[to]++;
                }
            }

            // 每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。
            if (Arrays.equals(expected, degrees)) {
                max = bitCount;
            }
        }
        return max;
    }
}
/*
1601. 最多可达成的换楼请求数目
https://leetcode.cn/problems/maximum-number-of-achievable-transfer-requests/

我们有 n 栋楼，编号从 0 到 n - 1 。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
给你一个数组 requests ，其中 requests[i] = [fromi, toi] ，表示一个员工请求从编号为 fromi 的楼搬到编号为 toi 的楼。
一开始 所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足 每栋楼员工净变化为 0 。
意思是每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。比方说 n = 3 且两个员工要离开楼 0 ，一个员工要离开楼 1 ，一个员工要离开楼 2 ，
如果该请求列表可行，应该要有两个员工搬入楼 0 ，一个员工搬入楼 1 ，一个员工搬入楼 2 。
请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
提示：
1 <= n <= 20
1 <= requests.length <= 16
requests[i].length == 2
0 <= fromi, toi < n

状态压缩 枚举
时间复杂度 O(n*2^m)
 */
