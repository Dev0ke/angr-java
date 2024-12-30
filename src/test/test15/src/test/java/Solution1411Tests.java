import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1411Tests {
    private final Solution1411 solution1411 = new Solution1411();

    @Test
    public void example1() {
        int n = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution1411.numOfWays(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 54;
        Assertions.assertEquals(expected, solution1411.numOfWays(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int expected = 246;
        Assertions.assertEquals(expected, solution1411.numOfWays(n));
    }

    @Test
    public void example4() {
        int n = 7;
        int expected = 106494;
        Assertions.assertEquals(expected, solution1411.numOfWays(n));
    }

    @Test
    public void example5() {
        int n = 5000;
        int expected = 30228214;
        Assertions.assertEquals(expected, solution1411.numOfWays(n));
    }
}
