import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2526Tests {
    @Test
    public void example1() {
        // value = 4, k = 3
        Solution2526.DataStream dataStream = new Solution2526.DataStream(4, 3);

        // 数据流中只有 1 个整数，所以返回 False 。
        Assertions.assertFalse(dataStream.consec(4));

        // 数据流中只有 2 个整数
        // 由于 2 小于 k ，返回 False 。
        Assertions.assertFalse(dataStream.consec(4));

        // 数据流最后 3 个整数都等于 value， 所以返回 True 。
        Assertions.assertTrue(dataStream.consec(4));

        // 最后 k 个整数分别是 [4,4,3] 。
        // 由于 3 不等于 value ，返回 False 。
        Assertions.assertFalse(dataStream.consec(3));
    }
}
