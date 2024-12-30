import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2729Tests {
    private final Solution2729 solution2729 = new Solution2729();

    @Test
    public void example1() {
        int n = 192;
        Assertions.assertTrue(solution2729.isFascinating(n));
    }

    @Test
    public void example2() {
        int n = 100;
        Assertions.assertFalse(solution2729.isFascinating(n));
    }
}