import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution232Tests {
    @Test
    public void example1() {
        Solution232.MyQueue myQueue = new Solution232.MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assertions.assertEquals(1, myQueue.peek());
        Assertions.assertEquals(1, myQueue.pop());
        Assertions.assertFalse(myQueue.empty());
    }
}
