import java.util.HashMap;
import java.util.Map;

public class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int key = Math.min(rectangle[0], rectangle[1]);
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }

        // max
        int max = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getKey() > max) {
                max = entry.getKey();
                res = entry.getValue();
            }
        }
        return res;
    }
}
/*
1725. 可以形成最大正方形的矩形数目
https://leetcode.cn/problems/number-of-rectangles-that-can-form-the-largest-square/

给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
提示：
1 <= rectangles.length <= 1000
rectangles[i].length == 2
1 <= li, wi <= 10^9
li != wi

HashMap 统计。
 */