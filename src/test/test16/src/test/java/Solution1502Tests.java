import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1502Tests {
    private final Solution1502 solution1502 = new Solution1502();

    @Test
    public void example1() {
        int[] arr = {3, 5, 1};
        Assertions.assertTrue(solution1502.canMakeArithmeticProgression(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 4};
        Assertions.assertFalse(solution1502.canMakeArithmeticProgression(arr));
    }
}
