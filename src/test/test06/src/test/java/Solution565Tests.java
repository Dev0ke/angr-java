import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution565Tests {
    private final Solution565 solution565 = new Solution565();

    @Test
    public void example1() {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution565.arrayNesting(nums));
    }
}
