import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2064Tests {
    private final Solution2064 solution2064 = new Solution2064();

    @Test
    public void example1() {
        int n = 6;
        int[] quantities = {11, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution2064.minimizedMaximum(n, quantities));
    }

    @Test
    public void example2() {
        int n = 7;
        int[] quantities = {15, 10, 10};
        int expected = 5;
        Assertions.assertEquals(expected, solution2064.minimizedMaximum(n, quantities));
    }

    @Test
    public void example3() {
        int n = 1;
        int[] quantities = {100000};
        int expected = 100000;
        Assertions.assertEquals(expected, solution2064.minimizedMaximum(n, quantities));
    }
}
