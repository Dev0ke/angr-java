import java.util.Arrays;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 运载重量为 mid 时，能否在 days 天内将所有包裹送达 FFFTTT
    private boolean checkMid(int[] weights, int days, int mid) {
        int cnt = 1;
        int curWeight = 0;
        int idx = 0;
        while (idx < weights.length) {
            // 我们装载的重量不会超过船的最大运载重量。
            if (weights[idx] > mid) {
                return false;
            }
            curWeight += weights[idx];
            if (curWeight > mid) {
                curWeight = 0;
                cnt++;
            } else {
                idx++;
            }
        }
        return cnt <= days;
    }
}
/*
1011. 在 D 天内送达包裹的能力
https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/

第 128 场周赛 T3。

传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
提示：
1 <= days <= weights.length <= 5 * 10^4
1 <= weights[i] <= 500

二分
 */