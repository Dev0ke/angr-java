import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution923Tests {
    private final Solution923 solution923 = new Solution923();

    @Test
    public void example1() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        int expected = 20;
        Assertions.assertEquals(expected, solution923.threeSumMulti(arr, target));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 2, 2, 2, 2};
        int target = 5;
        int expected = 12;
        Assertions.assertEquals(expected, solution923.threeSumMulti(arr, target));
    }
}