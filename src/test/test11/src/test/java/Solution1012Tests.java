import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1012Tests {
    private final Solution1012 solution1012 = new Solution1012();

    @Test
    public void example1() {
        int n = 20;
        int expected = 1;
        Assertions.assertEquals(expected, solution1012.numDupDigitsAtMostN(n));
    }

    @Test
    public void example2() {
        int n = 100;
        int expected = 10;
        Assertions.assertEquals(expected, solution1012.numDupDigitsAtMostN(n));
    }

    @Test
    public void example3() {
        int n = 1000;
        int expected = 262;
        Assertions.assertEquals(expected, solution1012.numDupDigitsAtMostN(n));
    }
}
