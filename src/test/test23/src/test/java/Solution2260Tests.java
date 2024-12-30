import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2260Tests {
    private final Solution2260 solution2260 = new Solution2260();

    @Test
    public void example1() {
        int[] cards = {3, 4, 2, 3, 4, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solution2260.minimumCardPickup(cards));
    }

    @Test
    public void example2() {
        int[] cards = {1, 0, 5, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2260.minimumCardPickup(cards));
    }
}
