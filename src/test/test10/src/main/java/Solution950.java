import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        int[] ans = new int[n];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[q.remove()] = card;
            if (!q.isEmpty()) {
                q.add(q.remove());
            }
        }
        return ans;
    }
}
/*
950. 按递增顺序显示卡牌
https://leetcode.cn/problems/reveal-cards-in-increasing-order/description/

牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
现在，重复执行以下步骤，直到显示所有卡牌为止：
1.从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
2.如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
3.如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。
答案中的第一张牌被认为处于牌堆顶部。
提示：
1 <= A.length <= 1000
1 <= A[i] <= 10^6
对于所有的 i != j，A[i] != A[j]

模拟。逆向。
时间复杂度 O(nlogn)
 */