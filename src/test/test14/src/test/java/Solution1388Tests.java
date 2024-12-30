import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1388Tests {
    private final Solution1388 solution1388 = new Solution1388();

    @Test
    public void example1() {
        int[] slices = {1, 2, 3, 4, 5, 6};
        int expected = 10;
        Assertions.assertEquals(expected, solution1388.maxSizeSlices(slices));
    }

    @Test
    public void example2() {
        int[] slices = {8, 9, 8, 6, 1, 1};
        int expected = 16;
        Assertions.assertEquals(expected, solution1388.maxSizeSlices(slices));
    }
}
