import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3370Tests {
    private final Solution3370 solution3370 = new Solution3370();

    @Test
    public void example1() {
        int n = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution3370.smallestNumber(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 15;
        Assertions.assertEquals(expected, solution3370.smallestNumber(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3370.smallestNumber(n));
    }
}