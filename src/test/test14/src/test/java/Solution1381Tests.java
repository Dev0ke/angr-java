import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1381Tests {
    @Test
    public void example1() {
        // 栈是空的 []
        Solution1381.CustomStack stk = new Solution1381.CustomStack(3);

        // 栈变为 [1]
        stk.push(1);

        // 栈变为 [1, 2]
        stk.push(2);

        // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        Assertions.assertEquals(2, stk.pop());

        // 栈变为 [1, 2]
        stk.push(2);

        // 栈变为 [1, 2, 3]
        stk.push(3);

        // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        stk.push(4);

        // 栈变为 [101, 102, 103]
        stk.increment(5, 100);

        // 栈变为 [201, 202, 103]
        stk.increment(2, 100);

        // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        Assertions.assertEquals(103, stk.pop());

        // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        Assertions.assertEquals(202, stk.pop());

        // 返回 201 --> 返回栈顶值 201，栈变为 []
        Assertions.assertEquals(201, stk.pop());

        // 返回 -1 --> 栈为空，返回 -1
        Assertions.assertEquals(-1, stk.pop());
    }
}