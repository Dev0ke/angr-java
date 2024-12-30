import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1539Tests {
    private final Solution1539 solution1539 = new Solution1539();

    @Test
    public void example1() {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int expected = 9;
        Assertions.assertEquals(expected, solution1539.findKthPositive(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1539.findKthPositive(arr, k));
    }
}
