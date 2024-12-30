import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2231Tests {
    private final Solution2231 solution2231 = new Solution2231();

    @Test
    public void example1() {
        int num = 1234;
        int expected = 3412;
        Assertions.assertEquals(expected, solution2231.largestInteger(num));
    }

    @Test
    public void example2() {
        int num = 65875;
        int expected = 87655;
        Assertions.assertEquals(expected, solution2231.largestInteger(num));
    }
}
