import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1891Tests {
    private final SolutionP1891 solutionP1891 = new SolutionP1891();

    @Test
    public void example1() {
        int[] ribbons = {9, 7, 5};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP1891.maxLength(ribbons, k));
    }

    @Test
    public void example2() {
        int[] ribbons = {7, 5, 9};
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1891.maxLength(ribbons, k));
    }

    @Test
    public void example3() {
        int[] ribbons = {5, 7, 9};
        int k = 22;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1891.maxLength(ribbons, k));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] ribbons = {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 1, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000};
        int k = 49;
        int expected = 100000;
        Assertions.assertEquals(expected, solutionP1891.maxLength(ribbons, k));
    }
}