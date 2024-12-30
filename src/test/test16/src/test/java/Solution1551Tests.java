import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1551Tests {
    private final Solution1551 solution1551 = new Solution1551();

    @Test
    public void example1() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1551.minOperations(n));
        Assertions.assertEquals(expected, solution1551.minOperations2(n));
    }

    @Test
    public void example2() {
        int n = 6;
        int expected = 9;
        Assertions.assertEquals(expected, solution1551.minOperations(n));
        Assertions.assertEquals(expected, solution1551.minOperations2(n));
    }
}