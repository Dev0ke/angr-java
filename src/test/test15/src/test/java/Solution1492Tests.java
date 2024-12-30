import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1492Tests {
    private final Solution1492 solution1492 = new Solution1492();

    @Test
    public void example1() {
        int n = 12;
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1492.kthFactor(n, k));
    }

    @Test
    public void example2() {
        int n = 7;
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1492.kthFactor(n, k));
    }

    @Test
    public void example3() {
        int n = 4;
        int k = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution1492.kthFactor(n, k));
    }
}