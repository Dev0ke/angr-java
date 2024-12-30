import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Solution1405Tests {
    private final Solution1405.V1 solution1405_v1 = new Solution1405.V1();
    private final Solution1405.V2 solution1405_v2 = new Solution1405.V2();

    @Test
    public void example1() {
        int a = 1;
        int b = 1;
        int c = 7;
        Set<String> expectedSet = Set.of("ccaccbcc", "ccbccacc");
        Assertions.assertTrue(expectedSet.contains(solution1405_v1.longestDiverseString(a, b, c)));
        Assertions.assertTrue(expectedSet.contains(solution1405_v2.longestDiverseString(a, b, c)));
    }

    @Test
    public void example2() {
        int a = 2;
        int b = 2;
        int c = 1;
        // 答案不唯一
        Set<String> expectedSet = Set.of("aabbc", "ababc");
        Assertions.assertTrue(expectedSet.contains(solution1405_v1.longestDiverseString(a, b, c)));
//        Assertions.assertTrue(expectedSet.contains(solution1405_v2.longestDiverseString(a, b, c)));
    }

    @Test
    public void example3() {
        int a = 7;
        int b = 1;
        int c = 0;
        String expected = "aabaa";
        Assertions.assertEquals(expected, solution1405_v1.longestDiverseString(a, b, c));
        Assertions.assertEquals(expected, solution1405_v2.longestDiverseString(a, b, c));
    }
}
