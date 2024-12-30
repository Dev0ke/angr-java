import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3274Tests {
    private final Solution3274 solution3274 = new Solution3274();

    @Test
    public void example1() {
        String coordinate1 = "a1";
        String coordinate2 = "c3";
        Assertions.assertTrue(solution3274.checkTwoChessboards(coordinate1, coordinate2));
    }

    @Test
    public void example2() {
        String coordinate1 = "a1";
        String coordinate2 = "h3";
        Assertions.assertFalse(solution3274.checkTwoChessboards(coordinate1, coordinate2));
    }
}