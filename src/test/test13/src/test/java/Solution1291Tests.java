import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1291Tests {
    private final Solution1291 solution1291 = new Solution1291();

    @Test
    public void example1() {
        int low = 100;
        int high = 300;
        List<Integer> expected = List.of(123, 234);
        Assertions.assertEquals(expected, solution1291.sequentialDigits(low, high));
    }

    @Test
    public void example2() {
        int low = 1000;
        int high = 13000;
        List<Integer> expected = List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345);
        Assertions.assertEquals(expected, solution1291.sequentialDigits(low, high));
    }
}