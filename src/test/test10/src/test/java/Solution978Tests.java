import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution978Tests {
    private final Solution978 solution978 = new Solution978();

    @Test
    public void example1() {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int expected = 5;
        Assertions.assertEquals(expected, solution978.maxTurbulenceSize(arr));
    }

    @Test
    public void example2() {
        int[] arr = {4, 8, 12, 16};
        int expected = 2;
        Assertions.assertEquals(expected, solution978.maxTurbulenceSize(arr));
    }

    @Test
    public void example3() {
        int[] arr = {100};
        int expected = 1;
        Assertions.assertEquals(expected, solution978.maxTurbulenceSize(arr));
    }
}