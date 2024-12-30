import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int card : deck) {
            cntMap.put(card, cntMap.getOrDefault(card, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(cntMap.values());
        int gcd = values.get(0);
        for (int value : values) {
            gcd = getGCD(gcd, value);
        }
        return gcd >= 2;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
914. 卡牌分组
https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/

第 104 场周赛 T1。

给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
- 每组都有 X 张牌。
- 组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
提示：
1 <= deck.length <= 10^4
0 <= deck[i] < 10^4

统计各数字频次。然后判断频次的最大公约数是否 >= 2 即可。
时间复杂度：O(NlogC)，其中 N 是卡牌的个数，C 是数组 deck 中数的范围，在本题中 C 的值为 10000。求两个数最大公约数的复杂度是 O(logC)
空间复杂度：O(N+C) 或 O(N)。
 */