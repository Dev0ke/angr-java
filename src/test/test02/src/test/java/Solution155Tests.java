import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution155Tests {
    @Test
    public void example1() {
        Solution155.MinStack minStack = new Solution155.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        // 返回 0.
        Assertions.assertEquals(0, minStack.top());
        // 返回 -2.
        Assertions.assertEquals(-2, minStack.getMin());
    }
}
