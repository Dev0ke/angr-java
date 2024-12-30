import java.util.HashMap;
import java.util.Map;

public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) {
            return "Flush";
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int rank : ranks) {
            cntMap.put(rank, cntMap.getOrDefault(rank, 0) + 1);
        }
        for (int cnt : cntMap.values()) {
            if (cnt >= 3) {
                return "Three of a Kind";
            }
        }
        for (int cnt : cntMap.values()) {
            if (cnt >= 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}
/*
2347. 最好的扑克手牌
https://leetcode.cn/problems/best-poker-hand/

第 83 场双周赛 T1。

给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
下述是从好到坏你可能持有的 手牌类型 ：
1."Flush"：同花，五张相同花色的扑克牌。
2."Three of a Kind"：三条，有 3 张大小相同的扑克牌。
3."Pair"：对子，两张大小一样的扑克牌。
4."High Card"：高牌，五张大小互不相同的扑克牌。
请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
注意：返回的字符串 大小写 需与题目描述相同。
提示：
ranks.length == suits.length == 5
1 <= ranks[i] <= 13
'a' <= suits[i] <= 'd'
任意两张扑克牌不会同时有相同的大小和花色。

模拟。
 */