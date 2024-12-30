import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1526Tests {
    private final Solution1526 solution1526 = new Solution1526();

    @Test
    public void example1() {
        int[] target = {1, 2, 3, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1526.minNumberOperations(target));
    }

    @Test
    public void example2() {
        int[] target = {3, 1, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution1526.minNumberOperations(target));
    }

    @Test
    public void example3() {
        int[] target = {3, 1, 5, 4, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution1526.minNumberOperations(target));
    }

    @Test
    public void example4() {
        int[] target = {1, 1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1526.minNumberOperations(target));
    }
}
