import java.util.List;

public class SolutionP339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}
/*
$339. 嵌套列表权重和
https://leetcode.cn/problems/nested-list-weight-sum/

给定一个嵌套的整数列表 nestedList ，每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
整数的 深度 是其在列表内部的嵌套层数。例如，嵌套列表 [1,[2,2],[[3],2],1] 中每个整数的值就是其深度。
请返回该列表按深度加权后所有整数的总和。
提示：
1 <= nestedList.length <= 50
嵌套列表中整数的值在范围 [-100, 100] 内
任何整数的最大 深度 都小于或等于 50

相似题目: 341. 扁平化嵌套列表迭代器
https://leetcode.cn/problems/flatten-nested-list-iterator/
$364. 加权嵌套序列和 II
https://leetcode.cn/problems/nested-list-weight-sum-ii/
385. 迷你语法分析器
https://leetcode.cn/problems/mini-parser/
 */