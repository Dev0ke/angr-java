import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1521Tests {
    private final Solution1521 solution1521 = new Solution1521();

    @Test
    public void example1() {
        int[] arr = {9, 12, 3, 7, 15};
        int target = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1521.closestToTarget(arr, target));
    }

    @Test
    public void example2() {
        int[] arr = {1000000, 1000000, 1000000};
        int target = 1;
        int expected = 999999;
        Assertions.assertEquals(expected, solution1521.closestToTarget(arr, target));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 4, 8, 16};
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution1521.closestToTarget(arr, target));
    }
}
