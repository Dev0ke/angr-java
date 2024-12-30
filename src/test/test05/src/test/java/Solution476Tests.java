import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution476Tests {
    private final Solution476 solution476 = new Solution476();

    @Test
    public void example1() {
        int num = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution476.findComplement(num));
    }

    @Test
    public void example2() {
        int num = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution476.findComplement(num));
    }
}
