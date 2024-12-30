import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2866Tests {
    private final Solution2866.V1 solution2866_v1 = new Solution2866.V1();
    private final Solution2866.V2 solution2866_v2 = new Solution2866.V2();

    @Test
    public void example1() {
        List<Integer> maxHeights = Arrays.asList(5, 3, 4, 1, 1);
        long expected = 13;
        Assertions.assertEquals(expected, solution2866_v1.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866_v2.maximumSumOfHeights(maxHeights));
    }

    @Test
    public void example2() {
        List<Integer> maxHeights = Arrays.asList(6, 5, 3, 9, 2, 7);
        long expected = 22;
        Assertions.assertEquals(expected, solution2866_v1.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866_v2.maximumSumOfHeights(maxHeights));
    }

    @Test
    public void example3() {
        List<Integer> maxHeights = Arrays.asList(3, 2, 5, 5, 2, 3);
        long expected = 18;
        Assertions.assertEquals(expected, solution2866_v1.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866_v2.maximumSumOfHeights(maxHeights));
    }
}