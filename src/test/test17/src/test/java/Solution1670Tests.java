import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1670Tests {
    @Test
    public void example1() {
        Solution1670.FrontMiddleBackQueue q = new Solution1670.FrontMiddleBackQueue();

        // [1]
        q.pushFront(1);

        // [1, 2]
        q.pushBack(2);

        // [1, 3, 2]
        q.pushMiddle(3);

        // [1, 4, 3, 2]
        q.pushMiddle(4);

        // 返回 1 -> [4, 3, 2]
        Assertions.assertEquals(1, q.popFront());

        // 返回 3 -> [4, 2]
        Assertions.assertEquals(3, q.popMiddle());

        // 返回 4 -> [2]
        Assertions.assertEquals(4, q.popMiddle());

        // 返回 2 -> []
        Assertions.assertEquals(2, q.popBack());

        // 返回 -1 -> [] （队列为空）
        Assertions.assertEquals(-1, q.popFront());
    }
}