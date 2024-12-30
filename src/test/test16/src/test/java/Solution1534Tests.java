import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1534Tests {
    private final Solution1534 solution1534 = new Solution1534();

    @Test
    public void example1() {
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution1534.countGoodTriplets(arr, a, b, c));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 2, 2, 3};
        int a = 0;
        int b = 0;
        int c = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1534.countGoodTriplets(arr, a, b, c));
    }
}
