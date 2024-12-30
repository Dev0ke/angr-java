import java.util.ArrayList;
import java.util.List;

public class SolutionP364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        int levelSum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    levelSum += n.getInteger();
                } else {
                    nextLevel.addAll(n.getList());
                }
            }
            nestedList = nextLevel;
            sum += levelSum;
        }
        return sum;
    }
}
/*
$364. 加权嵌套序列和 II
https://leetcode.cn/problems/nested-list-weight-sum-ii/

给你一个整数嵌套列表 nestedList ，每一个元素要么是一个整数，要么是一个列表（这个列表中的每个元素也同样是整数或列表）。
整数的 深度 取决于它位于多少个列表内部。例如，嵌套列表 [1,[2,2],[[3],2],1] 的每个整数的值都等于它的 深度 。令 maxDepth 是任意整数的 最大深度 。
整数的 权重 为 maxDepth - (整数的深度) + 1 。
将 nestedList 列表中每个整数先乘权重再求和，返回该加权和。
提示：
1 <= nestedList.length <= 50
嵌套列表中整数的值在范围 [-100, 100]
任意整数的最大 深度 小于等于 50

相似题目: $339. 嵌套列表权重和
https://leetcode.cn/problems/nested-list-weight-sum/
341. 扁平化嵌套列表迭代器
https://leetcode.cn/problems/flatten-nested-list-iterator/
385. 迷你语法分析器
https://leetcode.cn/problems/mini-parser/
 */
