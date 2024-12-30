import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution393Tests {
    private final Solution393 solution393 = new Solution393();

    @Test
    public void example1() {
        int[] data = {197, 130, 1};
        Assertions.assertTrue(solution393.validUtf8(data));
    }

    @Test
    public void example2() {
        int[] data = {235, 140, 4};
        Assertions.assertFalse(solution393.validUtf8(data));
    }
}