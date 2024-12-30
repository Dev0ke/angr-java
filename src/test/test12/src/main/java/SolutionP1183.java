import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                int num = 1;
                num *= (width - 1 - i) / sideLength + 1;
                num *= (height - 1 - j) / sideLength + 1;
                nodes.add(num);
            }
        }

        int res = 0;
        nodes.sort(Comparator.reverseOrder());
        for (int i = 0; i < maxOnes; i++) {
            res += nodes.get(i);
        }
        return res;
    }
}
/*
$1183. 矩阵中 1 的最大数量
https://leetcode.cn/problems/maximum-number-of-ones/

现在有一个尺寸为 width * height 的矩阵 M，矩阵中的每个单元格的值不是 0 就是 1。
而且矩阵 M 中每个大小为 sideLength * sideLength 的 正方形 子阵中，1 的数量不得超过 maxOnes。
请你设计一个算法，计算矩阵中最多可以有多少个 1。
提示：
1 <= width, height <= 100
1 <= sideLength <= width, height
0 <= maxOnes <= sideLength * sideLength

计算左上角正方形的每个格子在整个矩形中有多少个等效位置，取等效位置最多的前 maxOnes 个即可。
https://leetcode.cn/problems/maximum-number-of-ones/solution/kao-lu-zui-zuo-shang-jiao-de-zheng-fang-xing-mei-g/
 */