import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1611Tests {
    private final Solution1611 solution1611 = new Solution1611();

    @Test
    public void example1() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1611.minimumOneBitOperations(n));
    }

    @Test
    public void example2() {
        int n = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution1611.minimumOneBitOperations(n));
    }
}