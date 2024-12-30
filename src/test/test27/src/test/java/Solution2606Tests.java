import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2606Tests {
    private final Solution2606 solution2606 = new Solution2606();

    @Test
    public void example1() {
        String s = "adaa";
        String chars = "d";
        int[] vals = {-1000};
        int expected = 2;
        Assertions.assertEquals(expected, solution2606.maximumCostSubstring(s, chars, vals));
    }

    @Test
    public void example2() {
        String s = "abc";
        String chars = "abc";
        int[] vals = {-1, -1, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2606.maximumCostSubstring(s, chars, vals));
    }
}