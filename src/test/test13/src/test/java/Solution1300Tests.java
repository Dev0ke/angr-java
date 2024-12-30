import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1300Tests {
    private final Solution1300 solution1300 = new Solution1300();

    @Test
    public void example1() {
        int[] arr = {4, 9, 3};
        int target = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution1300.findBestValue(arr, target));
    }

    @Test
    public void example2() {
        int[] arr = {2, 3, 5};
        int target = 10;
        int expected = 5;
        Assertions.assertEquals(expected, solution1300.findBestValue(arr, target));
    }

    @Test
    public void example3() {
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        int target = 56803;
        int expected = 11361;
        Assertions.assertEquals(expected, solution1300.findBestValue(arr, target));
    }
}
