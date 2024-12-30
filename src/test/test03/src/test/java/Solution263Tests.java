import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution263Tests {
    private final Solution263 solution263 = new Solution263();

    @Test
    public void example1() {
        int n = 6;
        Assertions.assertTrue(solution263.isUgly(n));
    }

    @Test
    public void example2() {
        int n = 8;
        Assertions.assertTrue(solution263.isUgly(n));
    }

    @Test
    public void example3() {
        int n = 14;
        Assertions.assertFalse(solution263.isUgly(n));
    }

    @Test
    public void example4() {
        int n = 1;
        Assertions.assertTrue(solution263.isUgly(n));
    }
}
