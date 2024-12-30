import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1399Tests {
    private final Solution1399 solution1399 = new Solution1399();

    @Test
    public void example1() {
        int n = 13;
        int expected = 4;
        Assertions.assertEquals(expected, solution1399.countLargestGroup(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1399.countLargestGroup(n));
    }

    @Test
    public void example3() {
        int n = 15;
        int expected = 6;
        Assertions.assertEquals(expected, solution1399.countLargestGroup(n));
    }

    @Test
    public void example4() {
        int n = 24;
        int expected = 5;
        Assertions.assertEquals(expected, solution1399.countLargestGroup(n));
    }
}