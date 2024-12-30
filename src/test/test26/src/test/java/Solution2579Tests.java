import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2579Tests {
    private final Solution2579 solution2579 = new Solution2579();

    @Test
    public void example1() {
        int n = 1;
        long expected = 1;
        Assertions.assertEquals(expected, solution2579.coloredCells(n));
    }

    @Test
    public void example2() {
        int n = 2;
        long expected = 5;
        Assertions.assertEquals(expected, solution2579.coloredCells(n));
    }
}