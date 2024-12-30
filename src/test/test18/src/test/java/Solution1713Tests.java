import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1713Tests {
    private final Solution1713 solution1713 = new Solution1713();

    @Test
    public void example1() {
        int[] target = {5, 1, 3};
        int[] arr = {9, 4, 2, 3, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution1713.minOperations(target, arr));
    }

    @Test
    public void example2() {
        int[] target = {6, 4, 8, 1, 3, 2};
        int[] arr = {4, 7, 6, 2, 3, 8, 6, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1713.minOperations(target, arr));
    }
}
