import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution765Tests {
    private final Solution765 solution765 = new Solution765();

    @Test
    public void example1() {
        int[] row = {0, 2, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution765.minSwapsCouples(row));
    }

    @Test
    public void example2() {
        int[] row = {3, 2, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution765.minSwapsCouples(row));
    }
}
