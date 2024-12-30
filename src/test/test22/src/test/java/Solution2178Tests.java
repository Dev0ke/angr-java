import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2178Tests {
    private final Solution2178 solution2178 = new Solution2178();

    @Test
    public void example1() {
        long finalSum = 12;
        List<Long> expected = Arrays.asList(2L, 4L, 6L);
        List<Long> actual = solution2178.maximumEvenSplit(finalSum);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        long finalSum = 7;
        List<Long> expected = Arrays.asList();
        List<Long> actual = solution2178.maximumEvenSplit(finalSum);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        long finalSum = 28;
        // 以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
        //(6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
        //[10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
        List<Long> expected = Arrays.asList(2L, 4L, 6L, 16L);
        List<Long> actual = solution2178.maximumEvenSplit(finalSum);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
