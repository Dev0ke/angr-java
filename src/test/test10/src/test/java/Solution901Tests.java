import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution901Tests {
    @Test
    public void example1() {
        Solution901.StockSpanner stockSpanner = new Solution901.StockSpanner();
        // 被调用并返回 1
        Assertions.assertEquals(1, stockSpanner.next(100));
        // 被调用并返回 1
        Assertions.assertEquals(1, stockSpanner.next(80));
        // 被调用并返回 1
        Assertions.assertEquals(1, stockSpanner.next(60));
        // 被调用并返回 2
        Assertions.assertEquals(2, stockSpanner.next(70));
        // 被调用并返回 1
        Assertions.assertEquals(1, stockSpanner.next(60));
        // 被调用并返回 4
        Assertions.assertEquals(4, stockSpanner.next(75));
        // 被调用并返回 6
        Assertions.assertEquals(6, stockSpanner.next(85));
    }
}
