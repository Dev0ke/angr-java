import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1496Tests {
    private final Solution1496 solution1496 = new Solution1496();

    @Test
    public void example1() {
        String path = "NES";
        Assertions.assertFalse(solution1496.isPathCrossing(path));
    }

    @Test
    public void example2() {
        String path = "NESWW";
        Assertions.assertTrue(solution1496.isPathCrossing(path));
    }
}