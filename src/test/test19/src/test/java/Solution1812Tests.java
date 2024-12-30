import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1812Tests {
    private final Solution1812 solution1812 = new Solution1812();

    @Test
    public void example1() {
        String coordinates = "a1";
        Assertions.assertFalse(solution1812.squareIsWhite(coordinates));
    }

    @Test
    public void example2() {
        String coordinates = "h3";
        Assertions.assertTrue(solution1812.squareIsWhite(coordinates));
    }

    @Test
    public void example3() {
        String coordinates = "c7";
        Assertions.assertFalse(solution1812.squareIsWhite(coordinates));
    }
}