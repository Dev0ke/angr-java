import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2876Tests {
    private final Solution2876 solution2876 = new Solution2876();

    @Test
    public void example1() {
        List<Integer> edges = List.of(1, 2, 0, 0);
        int[] expected = {3, 3, 3, 4};
        Assertions.assertArrayEquals(expected, solution2876.countVisitedNodes(edges));
    }

    @Test
    public void example2() {
        List<Integer> edges = List.of(1, 2, 3, 4, 0);
        int[] expected = {5, 5, 5, 5, 5};
        Assertions.assertArrayEquals(expected, solution2876.countVisitedNodes(edges));
    }
}