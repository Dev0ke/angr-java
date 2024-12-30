import java.util.ArrayList;
import java.util.List;

public class Solution1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> resList = new ArrayList<>();
        int y = 1000;
        for (int x = 1; x <= 1000; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                resList.add(List.of(x, y));
            }
        }
        return resList;
    }

    static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }
}
/*
1237. 找出给定方程的正整数解
https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/

给你一个函数  f(x, y) 和一个目标结果 z，函数公式未知，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。满足条件的结果数对可以按任意顺序返回。
尽管函数的具体式子未知，但它是单调递增函数，也就是说：
f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)
函数接口定义如下：
```
interface CustomFunction {
public:
  // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
  int f(int x, int y);
};
```
你的解决方案将按如下规则进行评判：
- 判题程序有一个由 CustomFunction 的 9 种实现组成的列表，以及一种为特定的 z 生成所有有效数对的答案的方法。
- 判题程序接受两个输入：function_id（决定使用哪种实现测试你的代码）以及目标结果 z 。
- 判题程序将会调用你实现的 findSolution 并将你的结果与答案进行比较。
- 如果你的结果与答案相符，那么解决方案将被视作正确答案，即 Accepted 。
提示：
1 <= function_id <= 9
1 <= z <= 100
题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。

双指针。
相似题目: 240. 搜索二维矩阵 II
https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */

