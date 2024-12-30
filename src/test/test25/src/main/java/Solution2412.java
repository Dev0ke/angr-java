import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2412 {
    public long minimumMoney(int[][] transactions) {
        List<int[]> negativeList = new ArrayList<>();
        List<int[]> positiveList = new ArrayList<>();
        for (int[] transaction : transactions) {
            if (transaction[1] - transaction[0] <= 0) {
                negativeList.add(transaction);
            } else {
                positiveList.add(transaction);
            }
        }
        negativeList.sort(Comparator.comparingInt(o -> o[1]));
        positiveList.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        long money = 0;
        long min = Long.MAX_VALUE;
        for (int[] ints : negativeList) {
            money -= ints[0];
            min = Math.min(min, money);
            money += ints[1];
        }
        for (int[] ints : positiveList) {
            money -= ints[0];
            min = Math.min(min, money);
            money += ints[1];
        }
        return -min;
    }
}
/*
2412. 完成所有交易的初始最少钱数
https://leetcode.cn/problems/minimum-money-required-before-transactions/

第 87 场双周赛 T4。

给你一个下标从 0 开始的二维整数数组 transactions，其中transactions[i] = [costi, cashbacki] 。
数组描述了若干笔交易。其中每笔交易必须以 某种顺序 恰好完成一次。在任意一个时刻，你有一定数目的钱 money ，
为了完成交易 i ，money >= costi 这个条件必须为真。执行交易后，你的钱数 money 变成 money - costi + cashbacki 。
请你返回 任意一种 交易顺序下，你都能完成所有交易的最少钱数 money 是多少。
提示：
1 <= transactions.length <= 10^5
transactions[i].length == 2
0 <= costi, cashbacki <= 10^9

贪心。思考：如何才能尽可能亏得多？
对于亏钱的交易，亏钱多的越早越好，对于赚钱的交易，收益越高的越晚越好。先进行完所有亏钱交易，再进行赚钱交易。按顺序贪心取最小值即可。
时间复杂度 O(nlogn) 为排序时间复杂度。
 */