import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution868Tests {
    private final Solution868 solution868 = new Solution868();

    @Test
    public void example1() {
        int n = 22;
        int expected = 2;
        Assertions.assertEquals(expected, solution868.binaryGap(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution868.binaryGap(n));
    }

    @Test
    public void example3() {
        int n = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution868.binaryGap(n));
    }

    @Test
    public void example4() {
        int n = 8;
        int expected = 0;
        Assertions.assertEquals(expected, solution868.binaryGap(n));
    }

    @Test
    public void example5() {
        int n = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution868.binaryGap(n));
    }
}
