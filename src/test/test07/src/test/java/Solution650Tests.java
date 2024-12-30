import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution650Tests {
    private final Solution650 solution650 = new Solution650();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution650.minSteps(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution650.minSteps(n));
    }
}
