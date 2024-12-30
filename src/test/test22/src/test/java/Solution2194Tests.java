import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2194Tests {
    private final Solution2194 solution2194 = new Solution2194();

    @Test
    public void example1() {
        String s = "K1:L2";
        List<String> expected = List.of("K1", "K2", "L1", "L2");
        Assertions.assertEquals(expected, solution2194.cellsInRange(s));
    }

    @Test
    public void example2() {
        String s = "A1:F1";
        List<String> expected = List.of("A1", "B1", "C1", "D1", "E1", "F1");
        Assertions.assertEquals(expected, solution2194.cellsInRange(s));
    }
}
