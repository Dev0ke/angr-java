import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution788Tests {
    private final Solution788 solution788 = new Solution788();

    @Test
    public void example1() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution788.rotatedDigits(n));
    }
}
