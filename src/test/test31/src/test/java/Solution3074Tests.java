import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3074Tests {
    private final Solution3074 solution3074 = new Solution3074();

    @Test
    public void example1() {
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3074.minimumBoxes(apple, capacity));
    }

    @Test
    public void example2() {
        int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solution3074.minimumBoxes(apple, capacity));
    }
}