import java.util.Arrays;
import java.util.Comparator;

public class Solution2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        // reward1[i] - reward2[i] 大到小排取前 k 个
        Arrays.sort(ids, Comparator.comparingInt(o -> reward2[o] - reward1[o]));

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += reward1[ids[i]];
        }
        for (int i = k; i < n; i++) {
            ans += reward2[ids[i]];
        }
        return ans;
    }
}
/*
2611. 老鼠和奶酪
https://leetcode.cn/problems/mice-and-cheese/

第 339 场周赛 T3。

有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
下标为 i 处的奶酪被吃掉的得分为：
- 如果第一只老鼠吃掉，则得分为 reward1[i] 。
- 如果第二只老鼠吃掉，则得分为 reward2[i] 。
给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
提示：
1 <= n == reward1.length == reward2.length <= 10^5
1 <= reward1[i], reward2[i] <= 1000
0 <= k <= n

贪心 + 排序
时间复杂度 O(nlogn)
 */