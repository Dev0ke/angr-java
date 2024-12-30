import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2812Tests {
    private final Solution2812 solution2812 = new Solution2812();

    @Test
    public void example1() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[1,0,0],[0,0,0],[0,0,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor(grid));
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor2(grid));
    }

    @Test
    public void example2() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[0,0,1],[0,0,0],[0,0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor(grid));
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor2(grid));
    }

    @Test
    public void example3() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor(grid));
        Assertions.assertEquals(expected, solution2812.maximumSafenessFactor2(grid));
    }
}