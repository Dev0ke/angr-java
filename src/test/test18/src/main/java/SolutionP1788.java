import java.util.HashMap;
import java.util.Map;

public class SolutionP1788 {
    public int maximumBeauty(int[] flowers) {
        int n = flowers.length;
        int[] ps = new int[n + 1];
        // 记录每个元素出现的最右位置
        Map<Integer, Integer> rMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + Math.max(0, flowers[i]);
            rMap.put(flowers[i], i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Integer r = rMap.get(flowers[i]);
            if (r > i) {
//                ans = Math.max(ans, ps[r + 1] - ps[i]);
                ans = Math.max(ans, ps[r] - ps[i + 1] + flowers[i] * 2);
            }
        }
        return ans;
    }
}
/*
$1788. 最大化花园的美观度
https://leetcode.cn/problems/maximize-the-beauty-of-the-garden/description/

有一个花园，有 n 朵花，这些花都有一个用整数表示的美观度。这些花被种在一条线上。给定一个长度为 n 的整数类型数组 flowers ，每一个 flowers[i] 表示第 i 朵花的美观度。
一个花园满足下列条件时，该花园是有效的。
- 花园中至少包含两朵花。
- 第一朵花和最后一朵花的美观度相同。
作为一个被钦定的园丁，你可以从花园中去除任意朵花（也可以不去除任意一朵）。你想要通过一种方法移除某些花朵，使得剩下的花园变得有效。花园的美观度是其中所有剩余的花朵美观度之和。
返回你去除了任意朵花（也可以不去除任意一朵）之后形成的有效花园中最大可能的美观度。
提示：
2 <= flowers.length <= 10^5
-10^4 <= flowers[i] <= 10^4
去除一些花朵（可能没有）后，是有可能形成一个有效花园的。

前缀和。
 */