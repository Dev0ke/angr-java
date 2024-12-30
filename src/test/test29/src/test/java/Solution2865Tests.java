import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2865Tests {
    private final Solution2865 solution2865 = new Solution2865();

    @Test
    public void example1() {
        List<Integer> maxHeights = List.of(5, 3, 4, 1, 1);
        long expected = 13;
        Assertions.assertEquals(expected, solution2865.maximumSumOfHeights(maxHeights));
    }

    @Test
    public void example2() {
        List<Integer> maxHeights = List.of(6, 5, 3, 9, 2, 7);
        long expected = 22;
        Assertions.assertEquals(expected, solution2865.maximumSumOfHeights(maxHeights));
    }

    @Test
    public void example3() {
        List<Integer> maxHeights = List.of(3, 2, 5, 5, 2, 3);
        long expected = 18;
        Assertions.assertEquals(expected, solution2865.maximumSumOfHeights(maxHeights));
    }
}