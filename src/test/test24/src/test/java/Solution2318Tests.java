import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2318Tests {
    private final Solution2318 solution2318 = new Solution2318();

    @Test
    public void example1() {
        int n = 4;
        int expected = 184;
        Assertions.assertEquals(expected, solution2318.distinctSequences(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 22;
        Assertions.assertEquals(expected, solution2318.distinctSequences(n));
    }
}
