import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        Map<Integer, Integer> water = new HashMap<>();
        TreeSet<Integer> zero = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int rain = rains[i];
            if (rain == 0) {
                zero.add(i);
                continue;
            }
            // rain[i] > 0
            if (water.containsKey(rain)) {
                Integer higher = zero.higher(water.get(rain));
                // 晴天不够用了
                if (higher == null) {
                    return new int[0];
                }
                // 抽干这个湖泊
                res[higher] = rain;
                zero.remove(higher);
            }
            // 存放下雨的湖泊
            water.put(rain, i);
            // 下雨不能操作
            res[i] = -1;
        }
        return res;
    }
}
/*
1488. 避免洪水泛滥
https://leetcode.cn/problems/avoid-flood-in-the-city/

你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
给你一个整数数组 rains ，其中：
- rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
- rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
请返回一个数组 ans ，满足：
- ans.length == rains.length
- 如果 rains[i] > 0 ，那么ans[i] == -1 。
- 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
提示：
1 <= rains.length <= 10^5
0 <= rains[i] <= 10^9

二分查找 TreeSet 实现
时间复杂度 O(nlogn)
 */