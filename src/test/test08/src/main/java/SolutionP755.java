public class SolutionP755 {
    public int[] pourWater(int[] heights, int volume, int k) {
        while (volume-- > 0) {
            boolean flag = false;
            for (int d = -1; d <= 1; d += 2) {
                int i = k, best = k;
                while (0 <= i + d && i + d < heights.length && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) best = i + d;
                    i += d;
                }
                if (heights[best] < heights[k]) {
                    heights[best]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                heights[k]++;
            }
        }
        return heights;
    }

    public int[] pourWater2(int[] heights, int volume, int k) {
        while (volume-- > 0) {
            label:
            {
                for (int d = -1; d <= 1; d += 2) {
                    int i = k, best = k;
                    while (0 <= i + d && i + d < heights.length && heights[i + d] <= heights[i]) {
                        if (heights[i + d] < heights[i]) best = i + d;
                        i += d;
                    }
                    if (heights[best] < heights[k]) {
                        heights[best]++;
                        break label;
                    }
                }
                heights[k]++;
            }
        }
        return heights;
    }
}
/*
$755. 倒水
https://leetcode.cn/problems/pour-water/

给出一个地形高度图， heights[i] 表示该索引处的高度。每个索引的宽度为 1。在 V 个单位的水落在索引 K 处以后，每个索引位置有多少水？
水最先会在索引 K 处下降并且落在该索引位置的最高地形或水面之上。然后按如下方式流动：
- 如果液滴最终可以通过向左流动而下降，则向左流动。
- 否则，如果液滴最终可以通过向右流动而下降，则向右流动。
- 否则，在当前的位置上升。
- 这里，“最终下降” 的意思是液滴如果按此方向移动的话，最终可以下降到一个较低的水平。而且，“水平”的意思是当前列的地形的高度加上水的高度。
我们可以假定在数组两侧的边界外有无限高的地形。而且，不能有部分水在多于 1 个的网格块上均匀分布 - 每个单位的水必须要位于一个块中。
注：
heights 的长度为 [1, 100] ，并且每个数的范围为[0, 99]。
V 的范围 [0, 2000]。
K 的范围 [0, heights.length - 1]。

模拟
break label 过于抽象，可以学习 python for-else 语法 https://book.pythontips.com/en/latest/for_-_else.html
```
    public int[] pourWater2(int[] heights, int volume, int k) {
        while (volume-- > 0) droplet:{
            for (int d = -1; d <= 1; d += 2) {
                int i = k, best = k;
                while (0 <= i + d && i + d < heights.length && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) best = i + d;
                    i += d;
                }
                if (heights[best] < heights[k]) {
                    heights[best]++;
                    break droplet;
                }
            }
            heights[k]++;
        }
        return heights;
    }
```
 */