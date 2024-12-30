import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution975Tests {
    private final Solution975 solution975 = new Solution975();

    @Test
    public void example1() {
        int[] arr = {10, 13, 12, 14, 15};
        int expected = 2;
        Assertions.assertEquals(expected, solution975.oddEvenJumps(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 3, 1, 1, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution975.oddEvenJumps(arr));
    }

    @Test
    public void example3() {
        int[] arr = {5, 1, 3, 4, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution975.oddEvenJumps(arr));
    }
}