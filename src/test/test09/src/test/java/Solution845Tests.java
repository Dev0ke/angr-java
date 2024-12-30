import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution845Tests {
    private final Solution845 solution845 = new Solution845();

    @Test
    public void example1() {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution845.longestMountain(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 2, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution845.longestMountain(arr));
    }
}
