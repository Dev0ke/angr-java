import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1788Tests {
    private final SolutionP1788 solutionP1788 = new SolutionP1788();

    @Test
    public void example1() {
        int[] flowers = {1, 2, 3, 1, 2};
        int expected = 8;
        Assertions.assertEquals(expected, solutionP1788.maximumBeauty(flowers));
    }

    @Test
    public void example2() {
        int[] flowers = {100, 1, 1, -3, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1788.maximumBeauty(flowers));
    }

    @Test
    public void example3() {
        int[] flowers = {-1, -2, 0, -1};
        int expected = -2;
        Assertions.assertEquals(expected, solutionP1788.maximumBeauty(flowers));
    }
}