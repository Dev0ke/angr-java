import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1550Tests {
    private final Solution1550 solution1550 = new Solution1550();

    @Test
    public void example1() {
        int[] arr = {2, 6, 4, 1};
        Assertions.assertFalse(solution1550.threeConsecutiveOdds(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        Assertions.assertTrue(solution1550.threeConsecutiveOdds(arr));
    }
}