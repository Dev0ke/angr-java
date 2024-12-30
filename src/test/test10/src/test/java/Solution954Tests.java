import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution954Tests {
    private final Solution954 solution954 = new Solution954();

    @Test
    public void example1() {
        int[] arr = {3, 1, 3, 6};
        Assertions.assertFalse(solution954.canReorderDoubled(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 1, 2, 6};
        Assertions.assertFalse(solution954.canReorderDoubled(arr));
    }

    @Test
    public void example3() {
        int[] arr = {4, -2, 2, -4};
        Assertions.assertTrue(solution954.canReorderDoubled(arr));
    }
}