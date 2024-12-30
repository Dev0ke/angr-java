import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2544Tests {
    private final Solution2544 solution2544 = new Solution2544();

    @Test
    public void example1() {
        int n = 521;
        int expected = 4;
        Assertions.assertEquals(expected, solution2544.alternateDigitSum(n));
    }

    @Test
    public void example2() {
        int n = 111;
        int expected = 1;
        Assertions.assertEquals(expected, solution2544.alternateDigitSum(n));
    }

    @Test
    public void example3() {
        int n = 886996;
        int expected = 0;
        Assertions.assertEquals(expected, solution2544.alternateDigitSum(n));
    }
}