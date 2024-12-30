import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution319Tests {
    private final Solution319 solution319 = new Solution319();

    @Test
    public void example1() {
        int n = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution319.bulbSwitch(n));
    }

    @Test
    public void example2() {
        int n = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution319.bulbSwitch(n));
    }

    @Test
    public void example3() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution319.bulbSwitch(n));
    }
}
