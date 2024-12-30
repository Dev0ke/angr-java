import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution949Tests {
    private final Solution949 solution949 = new Solution949();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4};
        String expected = "23:41";
        Assertions.assertEquals(expected, solution949.largestTimeFromDigits(arr));
    }

    @Test
    public void example2() {
        int[] arr = {5, 5, 5, 5};
        String expected = "";
        Assertions.assertEquals(expected, solution949.largestTimeFromDigits(arr));
    }

    @Test
    public void example3() {
        int[] arr = {0, 0, 0, 0};
        String expected = "00:00";
        Assertions.assertEquals(expected, solution949.largestTimeFromDigits(arr));
    }

    @Test
    public void example4() {
        int[] arr = {0, 0, 1, 0};
        String expected = "10:00";
        Assertions.assertEquals(expected, solution949.largestTimeFromDigits(arr));
    }
}
