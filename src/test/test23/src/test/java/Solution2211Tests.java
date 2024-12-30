import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2211Tests {
    private final Solution2211 solution2211 = new Solution2211();

    @Test
    public void example1() {
        String directions = "RLRSLL";
        int expected = 5;
        Assertions.assertEquals(expected, solution2211.countCollisions(directions));
    }

    @Test
    public void example2() {
        String directions = "LLRR";
        int expected = 0;
        Assertions.assertEquals(expected, solution2211.countCollisions(directions));
    }
}
