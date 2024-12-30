import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2943Tests {
    private final Solution2943 solution2943 = new Solution2943();

    @Test
    public void example1() {
        int n = 2;
        int m = 1;
        int[] hBars = {2, 3};
        int[] vBars = {2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2943.maximizeSquareHoleArea(n, m, hBars, vBars));
    }

    @Test
    public void example2() {
        int n = 1;
        int m = 1;
        int[] hBars = {2};
        int[] vBars = {2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2943.maximizeSquareHoleArea(n, m, hBars, vBars));
    }

    @Test
    public void example3() {
        int n = 2;
        int m = 3;
        int[] hBars = {2, 3};
        int[] vBars = {2, 3, 4};
        int expected = 9;
        Assertions.assertEquals(expected, solution2943.maximizeSquareHoleArea(n, m, hBars, vBars));
    }
}