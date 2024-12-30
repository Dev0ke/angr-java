public class SolutionP251 {
    static class Vector2D {
        private final int[][] vec;
        private final int M;
        private int i;
        private int j;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            this.M = vec.length;
        }

        public int next() {
            hasNext();
            // 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。
            return vec[j][i++];
        }

        public boolean hasNext() {
            while (j < M && i == vec[j].length) {
                i = 0;
                j++;
            }
            return j < M;
        }
    }
}
/*
$251. 展开二维向量
https://leetcode.cn/problems/flatten-2d-vector/

请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。
示例：
Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
iterator.next(); // 返回 1
iterator.next(); // 返回 2
iterator.next(); // 返回 3
iterator.hasNext(); // 返回 true
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 4
iterator.hasNext(); // 返回 false
注意：
请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。
你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。
进阶：尝试在代码中仅使用 C++ 提供的迭代器 或 Java 提供的迭代器。

注意避免使用额外的数据结构，最小化辅助空间的使用。我们应尽可能的利用现有的数据结构，只需要添加足够多的额外空间来跟踪下一个值。
相似题目: $281. 锯齿迭代器
https://leetcode.cn/problems/zigzag-iterator/
 */