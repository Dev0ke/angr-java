import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2652Tests {
    private final Solution2652 solution2652 = new Solution2652();

    @Test
    public void example1() {
        int n = 7;
        int expected = 21;
        Assertions.assertEquals(expected, solution2652.sumOfMultiples(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 40;
        Assertions.assertEquals(expected, solution2652.sumOfMultiples(n));
    }

    @Test
    public void example3() {
        int n = 9;
        int expected = 30;
        Assertions.assertEquals(expected, solution2652.sumOfMultiples(n));
    }
}