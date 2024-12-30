import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1535Tests {
    private final Solution1535 solution1535 = new Solution1535();

    @Test
    public void example1() {
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution1535.getWinner(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {3, 2, 1};
        int k = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution1535.getWinner(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {1, 9, 8, 2, 3, 7, 6, 4, 5};
        int k = 7;
        int expected = 9;
        Assertions.assertEquals(expected, solution1535.getWinner(arr, k));
    }

    @Test
    public void example4() {
        int[] arr = {1, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        int k = 1000000000;
        int expected = 99;
        Assertions.assertEquals(expected, solution1535.getWinner(arr, k));
    }
}
