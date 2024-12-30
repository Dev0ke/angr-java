import java.util.Iterator;

public class Solution284 {
    static class PeekingIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer ret = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
}
/*
284. 顶端迭代器
https://leetcode.cn/problems/peeking-iterator/

请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
实现 PeekingIterator 类：
- PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
- int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
- bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
- int peek() 返回数组中的下一个元素，但 不 移动指针。
注意：每种语言可能有不同的构造函数和迭代器 Iterator，但均支持 int next() 和 boolean hasNext() 函数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
对 next 和 peek 的调用均有效
next、hasNext 和 peek 最多调用 1000 次
进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？

迭代器
进阶：使用泛型
 */