import java.util.ArrayList;
import java.util.List;

public class SolutionP281 {
    static class ZigzagIterator {
        private final List<List<Integer>> vList;
        private int i;
        private int j;
        private final int M;
        private final int N;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            vList = new ArrayList<>();
            vList.add(v1);
            vList.add(v2);
            M = vList.size();
            N = Math.max(v1.size(), v2.size());
            i = v1.size() > 0 ? 0 : 1;
            j = 0;
        }

        public int next() {
            int ans = vList.get(i).get(j);
            moveToNext();
            return ans;
        }

        public boolean hasNext() {
            return i < M && j < N;
        }

        private void moveToNext() {
            movePoint();
            if (j >= vList.get(i).size()) {
                movePoint();
            }
        }

        private void movePoint() {
            i++;
            if (i == M) {
                i = 0;
                j++;
            }
        }
    }
}
/*
$281. 锯齿迭代器
https://leetcode.cn/problems/zigzag-iterator/

给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
示例:
输入:
v1 = [1,2]
v2 = [3,4,5,6] 
输出: [1,3,2,4,5,6]
解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。
拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?
拓展声明：
 “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如：
输入:
[1,2,3]
[4,5,6,7]
[8,9]
输出: [1,4,8,2,5,9,3,6,7].

使用一个新的链表来保存数据，当然是最简单的。
但迭代器的目的就是使用最小辅助空间，来实现元素的迭代遍历，况且，如果题目给的是数据流输入呢？就无法应对了。
相似题目: $251. 展开二维向量
https://leetcode.cn/problems/flatten-2d-vector/
 */