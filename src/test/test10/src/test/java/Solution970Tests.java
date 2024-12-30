import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution970Tests {
    private final Solution970 solution970 = new Solution970();

    @Test
    public void example1() {
        int x = 2;
        int y = 3;
        int bound = 10;
        List<Integer> expected = List.of(2, 3, 4, 5, 7, 9, 10);
        Assertions.assertEquals(expected, solution970.powerfulIntegers(x, y, bound));
    }

    @Test
    public void example2() {
        int x = 3;
        int y = 5;
        int bound = 15;
        List<Integer> expected = List.of(2, 4, 6, 8, 10, 14);
        Assertions.assertEquals(expected, solution970.powerfulIntegers(x, y, bound));
    }
}
