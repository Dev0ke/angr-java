import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution622Tests {
    @Test
    public void example1() {
        // 设置长度为 3
        Solution622.MyCircularQueue circularQueue = new Solution622.MyCircularQueue(3);
        // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(1));
        // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(2));
        // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(3));
        // 返回 false，队列已满
        Assertions.assertFalse(circularQueue.enQueue(4));
        // 返回 3
        Assertions.assertEquals(3, circularQueue.Rear());
        // 返回 true
        Assertions.assertTrue(circularQueue.isFull());
        // 返回 true
        Assertions.assertTrue(circularQueue.deQueue());
        // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(4));
        // 返回 4
        Assertions.assertEquals(4, circularQueue.Rear());
    }
}
