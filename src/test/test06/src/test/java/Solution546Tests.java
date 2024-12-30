import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution546Tests {
    private final Solution546 solution546 = new Solution546();

    @Test
    public void example1() {
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        int expected = 23;
        Assertions.assertEquals(expected, solution546.removeBoxes(boxes));
    }

    @Test
    public void example2() {
        int[] boxes = {1, 1, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution546.removeBoxes(boxes));
    }

    @Test
    public void example3() {
        int[] boxes = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution546.removeBoxes(boxes));
    }
}
