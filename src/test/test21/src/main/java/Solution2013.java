import java.util.HashMap;
import java.util.Map;

public class Solution2013 {
    static class DetectSquares {
        //  mapMap.get(y).get(x) = n 表示 [x,y] 有 n 个点
        private final Map<Integer, Map<Integer, Integer>> yxMap;

        public DetectSquares() {
            yxMap = new HashMap<>();
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];

            Map<Integer, Integer> yMap = yxMap.getOrDefault(y, new HashMap<>());
            yMap.put(x, yMap.getOrDefault(x, 0) + 1);
            yxMap.put(y, yMap);
        }

        public int count(int[] point) {
            int x = point[0];
            int y = point[1];

            if (!yxMap.containsKey(y)) {
                return 0;
            }

            int res = 0;
            Map<Integer, Integer> yMap = yxMap.get(y);
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : yxMap.entrySet()) {
                int yy = entry.getKey();
                Map<Integer, Integer> xMap = entry.getValue();
                if (yy != y) {
                    // 根据对称性，这里可以不用取绝对值
                    int d = yy - y;
                    res += xMap.getOrDefault(x, 0) * yMap.getOrDefault(x + d, 0) * xMap.getOrDefault(x + d, 0);
                    res += xMap.getOrDefault(x, 0) * yMap.getOrDefault(x - d, 0) * xMap.getOrDefault(x - d, 0);
                }
            }
            return res;
        }
    }
}
/*
2013. 检测正方形
https://leetcode.cn/problems/detect-squares/

第 259 场周赛 T3。

给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
- 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
- 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
实现 DetectSquares 类：
- DetectSquares() 使用空数据结构初始化对象
- void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
- int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。

哈希表，输入点 (x,y)，枚举正方形边长 d 平行于 x 轴的另一条边纵坐标为 col，有 d = col - y 或 d = y - col
当 d = col - y 时，四点为 (x,y) (x,col) (x+d,y) (x+d,col)
当 d = y - col 时，四点为 (x,y) (x,col) (x-d,y) (x-d,col)
计算点数目的乘积和即可。
 */