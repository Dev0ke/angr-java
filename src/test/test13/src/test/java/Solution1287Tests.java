import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1287Tests {
    private final Solution1287 solution1287 = new Solution1287();

    @Test
    public void example1() {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int expected = 6;
        Assertions.assertEquals(expected, solution1287.findSpecialInteger(arr));
    }
}