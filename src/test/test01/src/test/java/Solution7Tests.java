import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution7Tests {
    private final Solution7 solution7 = new Solution7();

    @Test
    public void example1() {
        int x = 123;
        int expected = 321;
        Assertions.assertEquals(expected, solution7.reverse(x));
    }

    @Test
    public void example2() {
        int x = -123;
        int expected = -321;
        Assertions.assertEquals(expected, solution7.reverse(x));
    }

    @Test
    public void example3() {
        int x = 120;
        int expected = 21;
        Assertions.assertEquals(expected, solution7.reverse(x));
    }

    @Test
    public void example4() {
        int x = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution7.reverse(x));
    }
}
