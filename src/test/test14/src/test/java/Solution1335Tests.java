import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1335Tests {
    private final Solution1335 solution1335 = new Solution1335();

    @Test
    public void example1() {
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        int d = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1335.minDifficulty(jobDifficulty, d));
    }

    @Test
    public void example2() {
        int[] jobDifficulty = {9, 9, 9};
        int d = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution1335.minDifficulty(jobDifficulty, d));
    }

    @Test
    public void example3() {
        int[] jobDifficulty = {1, 1, 1};
        int d = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1335.minDifficulty(jobDifficulty, d));
    }

    @Test
    public void example4() {
        int[] jobDifficulty = {7, 1, 7, 1, 7, 1};
        int d = 3;
        int expected = 15;
        Assertions.assertEquals(expected, solution1335.minDifficulty(jobDifficulty, d));
    }

    @Test
    public void example5() {
        int[] jobDifficulty = {11, 111, 22, 222, 33, 333, 44, 444};
        int d = 6;
        int expected = 843;
        Assertions.assertEquals(expected, solution1335.minDifficulty(jobDifficulty, d));
    }
}