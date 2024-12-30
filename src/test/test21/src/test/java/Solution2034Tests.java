import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2034Tests {
    @Test
    public void example1() {
        Solution2034.StockPrice stockPrice = new Solution2034.StockPrice();
        // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(1, 10);
        // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.update(2, 5);
        // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        Assertions.assertEquals(5, stockPrice.current());
        // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        Assertions.assertEquals(10, stockPrice.maximum());
        // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        stockPrice.update(1, 3);

        // 返回 5 ，更正后最高价格为 5 。
        Assertions.assertEquals(5, stockPrice.maximum());
        // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        stockPrice.update(4, 2);
        // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
        Assertions.assertEquals(2, stockPrice.minimum());
    }
}
