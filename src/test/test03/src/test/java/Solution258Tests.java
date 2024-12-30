import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution258Tests {
    private final Solution258 solution258 = new Solution258();

    @Test
    public void example1() {
        int num = 38;
        int expected = 2;
        Assertions.assertEquals(expected, solution258.addDigits(num));
    }

    @Test
    public void example2() {
        int num = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution258.addDigits(num));
    }
}
