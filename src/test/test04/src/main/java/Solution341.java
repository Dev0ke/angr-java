import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution341 {
    static class NestedIterator implements Iterator<Integer> {
        private final List<Integer> list;
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            dfs(nestedList);
            iterator = list.iterator();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
/*
341. 扁平化嵌套列表迭代器
https://leetcode.cn/problems/flatten-nested-list-iterator/

给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
实现扁平迭代器类 NestedIterator ：
- NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
- int next() 返回嵌套列表的下一个整数。
- boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
你的代码将会用下述伪代码检测：
initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
提示：
1 <= nestedList.length <= 500
嵌套列表中的整数值在范围 [-10^6, 10^6] 内

相似题目: $339. 嵌套列表权重和
https://leetcode.cn/problems/nested-list-weight-sum/
$364. 加权嵌套序列和 II
https://leetcode.cn/problems/nested-list-weight-sum-ii/
385. 迷你语法分析器
https://leetcode.cn/problems/mini-parser/
 */