import java.util.TreeMap;

public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        // 平均分不了的用例不用看了
        if (len % groupSize != 0) {
            return false;
        }
        // 统计频次
        TreeMap<Integer, Integer> cntTreeMap = new TreeMap<>();
        for (int han : hand) {
            cntTreeMap.put(han, cntTreeMap.getOrDefault(han, 0) + 1);
        }
        // 每次从最小的取
        while (cntTreeMap.size() > 0) {
            int firstKey = cntTreeMap.firstKey();
            // 取连续的
            for (int i = firstKey; i < firstKey + groupSize; i++) {
                // 取不到返回 false
                if (!cntTreeMap.containsKey(i)) {
                    return false;
                }
                // 用掉这张牌，若用完要把对应 key 也 remove 掉
                int cnt = cntTreeMap.get(i);
                if (cnt == 1) {
                    cntTreeMap.remove(i);
                } else {
                    cntTreeMap.replace(i, cnt - 1);
                }
            }
        }
        return true;
    }
}
/*
846. 一手顺子
https://leetcode.cn/problems/hand-of-straights/

第 87 场周赛 T3。

Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
提示：
1 <= hand.length <= 10^4
0 <= hand[i] <= 10^9
1 <= groupSize <= hand.length

暴力模拟。从最小的牌开始取，连续取，若取完，即可以完成分组
注意 Map.replace(key, value) 与 Map.put(key, value) 区别：
replace 若 key 不存在不会往里放，put 不管是否存在都会往里放
同: 1296. 划分数组为连续数字的集合
https://leetcode.cn/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */