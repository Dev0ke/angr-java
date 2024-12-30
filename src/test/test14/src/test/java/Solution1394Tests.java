import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1394Tests {
    private final Solution1394 solution1394 = new Solution1394();

    @Test
    public void example1() {
        int[] arr = {2, 2, 3, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution1394.findLucky(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 2, 3, 3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1394.findLucky(arr));
    }

    @Test
    public void example3() {
        int[] arr = {2, 2, 2, 3, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution1394.findLucky(arr));
    }

    @Test
    public void example4() {
        int[] arr = {5};
        int expected = -1;
        Assertions.assertEquals(expected, solution1394.findLucky(arr));
    }

    @Test
    public void example5() {
        int[] arr = {7, 7, 7, 7, 7, 7, 7};
        int expected = 7;
        Assertions.assertEquals(expected, solution1394.findLucky(arr));
    }
}