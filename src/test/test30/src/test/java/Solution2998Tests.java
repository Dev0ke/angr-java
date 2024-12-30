import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2998Tests {
    private final Solution2998 solution2998 = new Solution2998();

    @Test
    public void example1() {
        int x = 26;
        int y = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2998.minimumOperationsToMakeEqual(x, y));
    }

    @Test
    public void example2() {
        int x = 54;
        int y = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2998.minimumOperationsToMakeEqual(x, y));
    }

    @Test
    public void example3() {
        int x = 25;
        int y = 30;
        int expected = 5;
        Assertions.assertEquals(expected, solution2998.minimumOperationsToMakeEqual(x, y));
    }
}