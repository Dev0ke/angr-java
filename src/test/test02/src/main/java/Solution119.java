import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> dpList = new ArrayList<>();
        dpList.add(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curLevel = new ArrayList<>();
            List<Integer> preLevel = dpList.get(i - 1);
            curLevel.add(1);
            for (int j = 0; j < preLevel.size() - 1; j++) {
                curLevel.add(preLevel.get(j) + preLevel.get(j + 1));
            }
            curLevel.add(1);
            dpList.add(curLevel);
        }
        return dpList.get(rowIndex);
    }
}
/*
119. 杨辉三角 II
https://leetcode.cn/problems/pascals-triangle-ii/

给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
提示:
0 <= rowIndex <= 33
进阶：
你可以优化你的算法到 O(rowIndex) 空间复杂度吗？

动态规划。
 */