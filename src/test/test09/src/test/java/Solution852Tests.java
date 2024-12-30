import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution852Tests {
    private final Solution852 solution852 = new Solution852();

    @Test
    public void example1() {
        int[] arr = {0, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray(arr));
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray2(arr));
    }

    @Test
    public void example2() {
        int[] arr = {0, 2, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray(arr));
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray2(arr));
    }

    @Test
    public void example3() {
        int[] arr = {0, 10, 5, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray(arr));
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray2(arr));
    }

    @Test
    public void example4() {
        int[] arr = {3, 4, 5, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray(arr));
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray2(arr));
    }

    @Test
    public void example5() {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int expected = 2;
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray(arr));
        Assertions.assertEquals(expected, solution852.peakIndexInMountainArray2(arr));
    }
}
