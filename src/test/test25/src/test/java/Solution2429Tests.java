import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2429Tests {
    private final Solution2429 solution2429 = new Solution2429();

    @Test
    public void example1() {
        int num1 = 3;
        int num2 = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution2429.minimizeXor(num1, num2));
    }

    @Test
    public void example2() {
        int num1 = 1;
        int num2 = 12;
        int expected = 3;
        Assertions.assertEquals(expected, solution2429.minimizeXor(num1, num2));
    }
}
