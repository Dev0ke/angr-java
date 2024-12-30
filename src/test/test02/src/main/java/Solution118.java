import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dpList = new ArrayList<>();
        dpList.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> curLevel = new ArrayList<>();
            List<Integer> preLevel = dpList.get(i - 1);
            curLevel.add(1);
            for (int j = 0; j < preLevel.size() - 1; j++) {
                curLevel.add(preLevel.get(j) + preLevel.get(j + 1));
            }
            curLevel.add(1);
            dpList.add(curLevel);
        }
        return dpList;
    }
}
/*
118. 杨辉三角
https://leetcode.cn/problems/pascals-triangle/

给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
提示:
1 <= numRows <= 30

动态规划。
 */