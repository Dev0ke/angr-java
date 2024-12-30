public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 1 <= n <= 2 * 10^4
        int len = n;
        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] booking : bookings) {
            // 从 1 到 n 进行编号，因此需 -1
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int change = booking[2];
            diff[i] += change;
            diff[j + 1] -= change;
        }
        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
/*
1109. 航班预订统计
https://leetcode.cn/problems/corporate-flight-bookings/

第 144 场周赛 T2。

这里有 n 个航班，它们分别从 1 到 n 进行编号。
有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）
的 每个航班 上预订了 seatsi 个座位。
请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
提示：
1 <= n <= 2 * 10^4
1 <= bookings.length <= 2 * 10^4
bookings[i].length == 3
1 <= firsti <= lasti <= n
1 <= seatsi <= 10^4

差分数组。
 */