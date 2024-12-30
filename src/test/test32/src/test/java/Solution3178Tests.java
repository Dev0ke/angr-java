import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3178Tests {
    private final Solution3178 solution3178 = new Solution3178();

    @Test
    public void example1() {
        int n = 3;
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution3178.numberOfChild(n, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3178.numberOfChild(n, k));
    }

    @Test
    public void example3() {
        int n = 4;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3178.numberOfChild(n, k));
    }
}