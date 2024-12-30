import java.util.HashMap;
import java.util.Map;

public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            // 求解区间分数和大于 0 的最长区间长度
            sum += hours[j] > 8 ? 1 : -1;
            if (sum > 0) {
                // [0, j]
                max = Math.max(max, j + 1);
            } else {
                if (sumMap.containsKey(sum - 1)) {
                    int i = sumMap.get(sum - 1);
                    // [0,j] - [0,i] = (i,j]
                    max = Math.max(max, j - i);
                }
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, j);
            }
        }
        return max;
    }
}
/*
1124. 表现良好的最长时间段
https://leetcode.cn/problems/longest-well-performing-interval/

给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
请你返回「表现良好时间段」的最大长度。
提示：
1 <= hours.length <= 10^4
0 <= hours[i] <= 16

前缀和 + 哈希
相似题目: 题目-02. 销售出色区间
https://leetcode.cn/contest/hhrc2022/problems/0Wx4Pc/
面试题 17.05. 字母与数字
https://leetcode.cn/problems/find-longest-subarray-lcci/
 */