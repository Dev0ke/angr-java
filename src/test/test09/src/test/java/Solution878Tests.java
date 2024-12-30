import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution878Tests {
    private final Solution878 solution878 = new Solution878();

    @Test
    public void example1() {
        int n = 1;
        int a = 2;
        int b = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution878.nthMagicalNumber(n, a, b));
    }

    @Test
    public void example2() {
        int n = 4;
        int a = 2;
        int b = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution878.nthMagicalNumber(n, a, b));
    }
}
