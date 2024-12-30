import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2283Tests {
    private final Solution2283 solution2283 = new Solution2283();

    @Test
    public void example1() {
        String num = "1210";
        Assertions.assertTrue(solution2283.digitCount(num));
    }

    @Test
    public void example2() {
        String num = "030";
        Assertions.assertFalse(solution2283.digitCount(num));
    }
}
