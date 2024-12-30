import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution641Tests {
    @Test
    public void example1() {
        // 设置容量大小为3
        Solution641.MyCircularDeque circularDeque = new Solution641.MyCircularDeque(3);
        // 返回 true
        Assertions.assertTrue(circularDeque.insertLast(1));
        // 返回 true
        Assertions.assertTrue(circularDeque.insertLast(2));
        // 返回 true
        Assertions.assertTrue(circularDeque.insertFront(3));
        // 已经满了，返回 false
        Assertions.assertFalse(circularDeque.insertFront(4));
        // 返回 2
        Assertions.assertEquals(2, circularDeque.getRear());
        // 返回 true
        Assertions.assertTrue(circularDeque.isFull());
        // 返回 true
        Assertions.assertTrue(circularDeque.deleteLast());
        // 返回 true
        Assertions.assertTrue(circularDeque.insertFront(4));
        // 返回 4
        Assertions.assertEquals(4, circularDeque.getFront());
    }
}
