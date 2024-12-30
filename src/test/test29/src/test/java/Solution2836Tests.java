import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2836Tests {
    private final Solution2836 solution2836 = new Solution2836();

    @Test
    public void example1() {
        List<Integer> receiver = List.of(2, 0, 1);
        long k = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solution2836.getMaxFunctionValue(receiver, k));
    }

    @Test
    public void example2() {
        List<Integer> receiver = List.of(1, 1, 1, 2, 3);
        long k = 3;
        long expected = 10;
        Assertions.assertEquals(expected, solution2836.getMaxFunctionValue(receiver, k));
    }
}