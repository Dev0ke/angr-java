import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3345Tests {
    private final Solution3345 solution3345 = new Solution3345();

    @Test
    public void example1() {
        int n = 10;
        int t = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution3345.smallestNumber(n, t));
    }

    @Test
    public void example2() {
        int n = 15;
        int t = 3;
        int expected = 16;
        Assertions.assertEquals(expected, solution3345.smallestNumber(n, t));
    }
}