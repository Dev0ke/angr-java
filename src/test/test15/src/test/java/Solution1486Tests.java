import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1486Tests {
    private final Solution1486 solution1486 = new Solution1486();

    @Test
    public void example1() {
        int n = 5;
        int start = 0;
        int expected = 8;
        Assertions.assertEquals(expected, solution1486.xorOperation(n, start));
        Assertions.assertEquals(expected, solution1486.xorOperation2(n, start));
    }

    @Test
    public void example2() {
        int n = 4;
        int start = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution1486.xorOperation(n, start));
        Assertions.assertEquals(expected, solution1486.xorOperation2(n, start));
    }

    @Test
    public void example3() {
        int n = 1;
        int start = 7;
        int expected = 7;
        Assertions.assertEquals(expected, solution1486.xorOperation(n, start));
        Assertions.assertEquals(expected, solution1486.xorOperation2(n, start));
    }

    @Test
    public void example4() {
        int n = 10;
        int start = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1486.xorOperation(n, start));
        Assertions.assertEquals(expected, solution1486.xorOperation2(n, start));
    }
}