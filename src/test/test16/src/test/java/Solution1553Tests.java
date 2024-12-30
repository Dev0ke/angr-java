import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1553Tests {
    private final Solution1553 solution1553 = new Solution1553();

    @Test
    public void example1() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution1553.minDays(n));
    }

    @Test
    public void example2() {
        int n = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution1553.minDays(n));
    }
}