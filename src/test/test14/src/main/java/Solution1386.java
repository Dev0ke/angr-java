import java.util.HashMap;
import java.util.Map;

public class Solution1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] p : reservedSeats) {
            int row = p[0], col = p[1];
            if (col >= 2 && col <= 9) { // 忽略 1 和 10
//                int origin = occupied.getOrDefault(row, 0);
//                int value = origin | (1 << (col - 2));
//                occupied.put(row, value);
                occupied.merge(row, 1 << (col - 2), (a, b) -> (a | b));
            }
        }

        int ans = (n - occupied.size()) * 2;
        for (Integer mask : occupied.values()) {
            if (((mask | left) == left)
                    || ((mask | middle) == middle)
                    || ((mask | right) == right)) {
                ans++;
            }
        }
        return ans;
    }
}
/*
1386. 安排电影院座位
https://leetcode.cn/problems/cinema-seat-allocation/description/

如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，reservedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
提示：
1 <= n <= 10^9
1 <= reservedSeats.length <= min(10*n, 10^4)
reservedSeats[i].length == 2
1 <= reservedSeats[i][0] <= n
1 <= reservedSeats[i][1] <= 10
所有 reservedSeats[i] 都是互不相同的。

位运算。
时间复杂度 O(reservedSeats.length)。
 */