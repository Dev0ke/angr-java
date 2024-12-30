import java.util.Arrays;
import java.util.List;

public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            minutes[i] = getMin(timePoints.get(i));
        }
        Arrays.sort(minutes);
        int ans = 1440 - minutes[n - 1] + minutes[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, minutes[i] - minutes[i - 1]);
        }
        return ans;
    }

    private int getMin(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}
/*
539. 最小时间差
https://leetcode.cn/problems/minimum-time-difference/

给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
提示：
2 <= timePoints.length <= 2 * 10^4
timePoints[i] 格式为 "HH:MM"

BitSet 长度为定长 1440，为常数，因此：
时间复杂度 O(1)
空间复杂度 O(1)
注意 BitSet#size()、BitSet#length() 与 boolean[] bitset; bitset.length 之间的区别
 */