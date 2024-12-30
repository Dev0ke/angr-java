import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2103Tests {
    private final Solution2103 solution2103 = new Solution2103();

    @Test
    public void example1() {
        String rings = "B0B6G0R6R0R6G9";
        int expected = 1;
        Assertions.assertEquals(expected, solution2103.countPoints(rings));
    }

    @Test
    public void example2() {
        String rings = "B0R0G0R9R0B0G0";
        int expected = 1;
        Assertions.assertEquals(expected, solution2103.countPoints(rings));
    }

    @Test
    public void example3() {
        String rings = "G4";
        int expected = 0;
        Assertions.assertEquals(expected, solution2103.countPoints(rings));
    }
}
