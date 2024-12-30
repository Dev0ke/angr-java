import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2895Tests {
    private final Solution2895 solution2895 = new Solution2895();

    @Test
    public void example1() {
        List<Integer> processorTime = Arrays.asList(8, 10);
        List<Integer> tasks = Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5);
        int expected = 16;
        Assertions.assertEquals(expected, solution2895.minProcessingTime(processorTime, tasks));
    }

    @Test
    public void example2() {
        List<Integer> processorTime = Arrays.asList(10, 20);
        List<Integer> tasks = Arrays.asList(2, 3, 1, 2, 5, 8, 4, 3);
        int expected = 23;
        Assertions.assertEquals(expected, solution2895.minProcessingTime(processorTime, tasks));
    }
}