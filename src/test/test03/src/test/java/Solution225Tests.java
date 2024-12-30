import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution225Tests {
    @Test
    public void example1() {
        Solution225.MyStack myStack = new Solution225.MyStack();
        myStack.push(1);
        myStack.push(2);
        Assertions.assertEquals(2, myStack.top());
        Assertions.assertEquals(2, myStack.pop());
        Assertions.assertFalse(myStack.empty());
    }
}
