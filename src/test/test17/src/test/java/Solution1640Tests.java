import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1640Tests {
    private final Solution1640 solution1640 = new Solution1640();

    @Test
    public void example1() {
        int[] arr = {15, 88};
        int[][] pieces = UtUtils.stringToInts2("[[88],[15]]");
        Assertions.assertTrue(solution1640.canFormArray(arr, pieces));
    }

    @Test
    public void example2() {
        int[] arr = {49, 18, 16};
        int[][] pieces = UtUtils.stringToInts2("[[16,18,49]]");
        Assertions.assertFalse(solution1640.canFormArray(arr, pieces));
    }

    @Test
    public void example3() {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = UtUtils.stringToInts2("[[78],[4,64],[91]]");
        Assertions.assertTrue(solution1640.canFormArray(arr, pieces));
    }

    @Test
    public void example4() {
        int[] arr = {1, 3, 5, 7};
        int[][] pieces = {{2, 4, 6, 8}};
        Assertions.assertFalse(solution1640.canFormArray(arr, pieces));
    }
}
