import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1718Tests {
    private final Solution1718 solution1718 = new Solution1718();

    @Test
    public void example1() {
        int n = 3;
        int[] expected = {3, 1, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution1718.constructDistancedSequence(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int[] expected = {5, 3, 1, 4, 3, 5, 2, 4, 2};
        Assertions.assertArrayEquals(expected, solution1718.constructDistancedSequence(n));
    }
}