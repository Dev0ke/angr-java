import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2260 {
    public int minimumCardPickup(int[] cards) {
        int len = cards.length;

        // 预处理下标数组
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.computeIfAbsent(cards[i], key -> new ArrayList<>()).add(i);
        }

        // 枚举求最小值
        int min = Integer.MAX_VALUE;
        for (List<Integer> idxList : idxMap.values()) {
            if (idxList.size() > 1) {
                for (int i = 1; i < idxList.size(); i++) {
                    min = Math.min(min, idxList.get(i) - idxList.get(i - 1) + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
/*
2260. 必须拿起的最小连续卡牌数
https://leetcode.cn/problems/minimum-consecutive-cards-to-pick-up/

第 291 场周赛 T2。

给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。
提示：
1 <= cards.length <= 10^5
0 <= cards[i] <= 10^6

枚举 & 贪心。拿起的最小连续卡牌第一张和最后一张必定相同，先预处理得出每张牌对应的下标数组，最小的下标间距即为答案。
时间复杂度: O(n)
 */