import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution506 {
    private static final String GOLD_MEDAL = "Gold Medal";
    private static final String SILVER_MEDAL = "Silver Medal";
    private static final String BRONZE_MEDAL = "Bronze Medal";

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int sco : score) {
            maxHeap.add(sco);
        }
        Map<Integer, Integer> orderMap = new HashMap<>();
        int n = score.length;
        for (int i = 1; i <= n; i++) {
            orderMap.put(maxHeap.remove(), i);
        }
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (orderMap.get(score[i]) == 1) {
                res[i] = GOLD_MEDAL;
            } else if (orderMap.get(score[i]) == 2) {
                res[i] = SILVER_MEDAL;
            } else if (orderMap.get(score[i]) == 3) {
                res[i] = BRONZE_MEDAL;
            } else {
                res[i] = String.valueOf(orderMap.get(score[i]));
            }
        }
        return res;
    }
}
/*
506. 相对名次
https://leetcode.cn/problems/relative-ranks/

给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
- 名次第 1 的运动员获金牌 "Gold Medal" 。
- 名次第 2 的运动员获银牌 "Silver Medal" 。
- 名次第 3 的运动员获铜牌 "Bronze Medal" 。
- 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
提示：
n == score.length
1 <= n <= 10^4
0 <= score[i] <= 10^6
score 中的所有值 互不相同

排序后输出。
时间复杂度 O(nlogn)
 */