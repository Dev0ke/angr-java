import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution284Tests {
    @Test
    public void example1() {
        // [1,2,3]
        Iterator<Integer> iterator = new Iterator<>() {
            final int[] arr = {1, 2, 3};
            int cursor;

            @Override
            public boolean hasNext() {
                return cursor < arr.length;
            }

            @Override
            public Integer next() {
                int i = cursor;
                if (i >= arr.length) {
                    throw new NoSuchElementException();
                }
                cursor = i + 1;
                return arr[i];
            }
        };
        Solution284.PeekingIterator peekingIterator = new Solution284.PeekingIterator(iterator);
        // 返回 1 ，指针移动到下一个元素 [1,2,3]
        Assertions.assertEquals(1, peekingIterator.next());
        // 返回 2 ，指针未发生移动 [1,2,3]
        Assertions.assertEquals(2, peekingIterator.peek());
        // 返回 2 ，指针移动到下一个元素 [1,2,3]
        Assertions.assertEquals(2, peekingIterator.next());
        // 返回 3 ，指针移动到下一个元素 [1,2,3]
        Assertions.assertEquals(3, peekingIterator.next());
        // 返回 False
        Assertions.assertFalse(peekingIterator.hasNext());
    }
}
