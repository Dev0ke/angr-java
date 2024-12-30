import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution672Tests {
    private final Solution672 solution672 = new Solution672();

    @Test
    public void example1() {
        int n = 1;
        int presses = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution672.flipLights(n, presses));
    }

    @Test
    public void example2() {
        int n = 2;
        int presses = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution672.flipLights(n, presses));
    }

    @Test
    public void example3() {
        int n = 3;
        int presses = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution672.flipLights(n, presses));
    }
}