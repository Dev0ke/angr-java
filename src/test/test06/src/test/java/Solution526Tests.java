import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution526Tests {
    private final Solution526 solution526 = new Solution526();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution526.countArrangement(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution526.countArrangement(n));
    }
}
