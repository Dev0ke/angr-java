import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1866Tests {
    private final Solution1866 solution1866 = new Solution1866();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1866.rearrangeSticks(n, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution1866.rearrangeSticks(n, k));
    }

    @Test
    public void example3() {
        int n = 20;
        int k = 11;
        int expected = 647427950;
        Assertions.assertEquals(expected, solution1866.rearrangeSticks(n, k));
    }
}
