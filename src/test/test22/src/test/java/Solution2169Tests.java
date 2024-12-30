import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2169Tests {
    private final Solution2169 solution2169 = new Solution2169();

    @Test
    public void example1() {
        int num1 = 2;
        int num2 = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2169.countOperations(num1, num2));
    }

    @Test
    public void example12() {
        int num1 = 10;
        int num2 = 10;
        int expected = 1;
        Assertions.assertEquals(expected, solution2169.countOperations(num1, num2));
    }
}
