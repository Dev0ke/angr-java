import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2379Tests {
    private final Solution2379 solution2379 = new Solution2379();

    @Test
    public void example1() {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution2379.minimumRecolors(blocks, k));
    }

    @Test
    public void example2() {
        String blocks = "WBWBBBW";
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2379.minimumRecolors(blocks, k));
    }
}
