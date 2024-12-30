import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution769Tests {
    private final Solution769 solution769 = new Solution769();

    @Test
    public void example1() {
        int[] arr = {4, 3, 2, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution769.maxChunksToSorted(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 0, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution769.maxChunksToSorted(arr));
    }
}
