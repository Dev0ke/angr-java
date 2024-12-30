import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2235Tests {
    private final Solution2235 solution2235 = new Solution2235();

    @Test
    public void example1() {
        int num1 = 12;
        int num2 = 5;
        int expected = 17;
        Assertions.assertEquals(expected, solution2235.sum(num1, num2));
    }

    @Test
    public void example2() {
        int num1 = -10;
        int num2 = 4;
        int expected = -6;
        Assertions.assertEquals(expected, solution2235.sum(num1, num2));
    }
}