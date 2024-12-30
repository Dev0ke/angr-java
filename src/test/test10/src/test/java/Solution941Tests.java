import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution941Tests {
    private final Solution941 solution941 = new Solution941();

    @Test
    public void example1() {
        int[] arr = {2, 1};
        Assertions.assertFalse(solution941.validMountainArray(arr));
    }

    @Test
    public void example2() {
        int[] arr = {3, 5, 5};
        Assertions.assertFalse(solution941.validMountainArray(arr));
    }

    @Test
    public void example3() {
        int[] arr = {0, 3, 2, 1};
        Assertions.assertTrue(solution941.validMountainArray(arr));
    }
}
