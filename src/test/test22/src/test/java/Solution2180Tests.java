import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2180Tests {
    private final Solution2180 solution2180 = new Solution2180();

    @Test
    public void example1() {
        int num = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2180.countEven(num));
    }

    @Test
    public void example2() {
        int num = 30;
        int expected = 14;
        Assertions.assertEquals(expected, solution2180.countEven(num));
    }
}
