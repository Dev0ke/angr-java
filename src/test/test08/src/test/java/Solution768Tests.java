import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution768Tests {
    private final Solution768 solution768 = new Solution768();

    @Test
    public void example1() {
        int[] arr = {5, 4, 3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution768.maxChunksToSorted(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 1, 3, 4, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution768.maxChunksToSorted(arr));
    }
}