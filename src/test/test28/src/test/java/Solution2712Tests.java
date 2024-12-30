import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2712Tests {
    private final Solution2712 solution2712 = new Solution2712();

    @Test
    public void example1() {
        String s = "0011";
        long expected = 2;
        Assertions.assertEquals(expected, solution2712.minimumCost(s));
    }

    @Test
    public void example2() {
        String s = "010101";
        long expected = 9;
        Assertions.assertEquals(expected, solution2712.minimumCost(s));
    }
}