import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1946Tests {
    private final Solution1946 solution1946 = new Solution1946();

    @Test
    public void example1() {
        String num = "132";
        int[] change = {9, 8, 5, 0, 3, 6, 4, 2, 6, 8};
        String expected = "832";
        Assertions.assertEquals(expected, solution1946.maximumNumber(num, change));
    }

    @Test
    public void example2() {
        String num = "021";
        int[] change = {9, 4, 3, 5, 7, 2, 1, 9, 0, 6};
        String expected = "934";
        Assertions.assertEquals(expected, solution1946.maximumNumber(num, change));
    }

    @Test
    public void example3() {
        String num = "5";
        int[] change = {1, 4, 7, 5, 3, 2, 5, 6, 9, 4};
        String expected = "5";
        Assertions.assertEquals(expected, solution1946.maximumNumber(num, change));
    }
}
