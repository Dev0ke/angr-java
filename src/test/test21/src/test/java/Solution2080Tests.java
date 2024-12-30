import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2080Tests {
    @Test
    public void example1() {
        Solution2080.RangeFreqQuery rangeFreqQuery = new Solution2080.RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
        Assertions.assertEquals(1, rangeFreqQuery.query(1, 2, 4));
        // 返回 2 。33 在整个子数组中出现 2 次。
        Assertions.assertEquals(2, rangeFreqQuery.query(0, 11, 33));
    }
}
