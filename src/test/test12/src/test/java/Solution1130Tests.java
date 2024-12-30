import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1130Tests {
    private final Solution1130 solution1130 = new Solution1130();

    @Test
    public void example1() {
        int[] arr = {6, 2, 4};
        int expected = 32;
        Assertions.assertEquals(expected, solution1130.mctFromLeafValues(arr));
    }

    @Test
    public void example2() {
        int[] arr = {4, 11};
        int expected = 44;
        Assertions.assertEquals(expected, solution1130.mctFromLeafValues(arr));
    }
}