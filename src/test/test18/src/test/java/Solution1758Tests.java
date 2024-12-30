import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1758Tests {
    private final Solution1758 solution1758 = new Solution1758();

    @Test
    public void example1() {
        String s = "0100";
        int expected = 1;
        Assertions.assertEquals(expected, solution1758.minOperations(s));
    }

    @Test
    public void example2() {
        String s = "10";
        int expected = 0;
        Assertions.assertEquals(expected, solution1758.minOperations(s));
    }

    @Test
    public void example3() {
        String s = "1111";
        int expected = 2;
        Assertions.assertEquals(expected, solution1758.minOperations(s));
    }
}
