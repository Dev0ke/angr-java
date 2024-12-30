import java.util.HashMap;
import java.util.Map;

public class Solution2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> cntMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            double key = height / (double) width;
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Double, Integer> entry : cntMap.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                res += ((long) value * value - value) / 2;
            }
        }
        return res;
    }
}
/*
2001. 可互换矩形的组数
https://leetcode.cn/problems/number-of-pairs-of-interchangeable-rectangles/

第 258 场周赛 T2。

用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。
更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
计算并返回 rectangles 中有多少对 可互换 矩形。

神奇。Double 也可以作为 HashMap 的 key
 */