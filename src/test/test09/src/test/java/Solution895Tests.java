import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution895Tests {
    @Test
    public void example1() {
        Solution895.FreqStack freqStack = new Solution895.FreqStack();
        // 堆栈为 [5]
        freqStack.push(5);
        // 堆栈是 [5,7]
        freqStack.push(7);
        // 堆栈是 [5,7,5]
        freqStack.push(5);
        // 堆栈是 [5,7,5,7]
        freqStack.push(7);
        // 堆栈是 [5,7,5,7,4]
        freqStack.push(4);
        // 堆栈是 [5,7,5,7,4,5]
        freqStack.push(5);

        // 返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        Assertions.assertEquals(5, freqStack.pop());
        // 返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        Assertions.assertEquals(7, freqStack.pop());
        // 返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        Assertions.assertEquals(5, freqStack.pop());
        // 返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
        Assertions.assertEquals(4, freqStack.pop());
    }
}
