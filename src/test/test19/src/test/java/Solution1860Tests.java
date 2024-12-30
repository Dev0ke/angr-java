import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1860Tests {
    private final Solution1860 solution1860 = new Solution1860();

    @Test
    public void example1() {
        int memory1 = 2;
        int memory2 = 2;
        int[] expected = {3, 1, 0};
        Assertions.assertArrayEquals(expected, solution1860.memLeak(memory1, memory2));
    }

    @Test
    public void example2() {
        int memory1 = 8;
        int memory2 = 11;
        int[] expected = {6, 0, 4};
        Assertions.assertArrayEquals(expected, solution1860.memLeak(memory1, memory2));
    }
}