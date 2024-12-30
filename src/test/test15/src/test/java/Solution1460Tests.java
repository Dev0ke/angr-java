import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1460Tests {
    private final Solution1460 solution1460 = new Solution1460();

    @Test
    public void example1() {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        Assertions.assertTrue(solution1460.canBeEqual(target, arr));
    }

    @Test
    public void example2() {
        int[] target = {7};
        int[] arr = {7};
        Assertions.assertTrue(solution1460.canBeEqual(target, arr));
    }

    @Test
    public void example3() {
        int[] target = {3, 7, 9};
        int[] arr = {3, 7, 11};
        Assertions.assertFalse(solution1460.canBeEqual(target, arr));
    }
}
