import java.util.Arrays;

public class Solution3281 {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);

        long left = 0;
        long right = (int) (2e9 + 5);
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(start, d, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left - 1);
    }

    private boolean checkMid(int[] start, int d, long score) {
        long x = Long.MIN_VALUE;
        for (int s : start) {
            x = Math.max(x + score, s); // x 必须 >= 区间左端点 s
            if (x > s + d) {
                return false;
            }
        }
        return true;
    }
}
/*
3281. 范围内整数的最大得分
https://leetcode.cn/problems/maximize-score-of-numbers-in-ranges/description/

第 414 场周赛 T2。

给你一个整数数组 start 和一个整数 d，代表 n 个区间 [start[i], start[i] + d]。
你需要选择 n 个整数，其中第 i 个整数必须属于第 i 个区间。所选整数的 得分 定义为所选整数两两之间的 最小 绝对差。
返回所选整数的 最大可能得分 。
提示：
2 <= start.length <= 10^5
0 <= start[i] <= 10^9
0 <= d <= 10^9

二分答案。
时间复杂度 O(nlogU)。其中 U = 2e9。
 */