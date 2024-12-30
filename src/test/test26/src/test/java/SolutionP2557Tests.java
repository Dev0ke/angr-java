import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2557Tests {
    private final SolutionP2557 solutionP2557 = new SolutionP2557();

    @Test
    public void example1() {
        int[] banned = {1, 4, 6};
        int n = 6;
        long maxSum = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2557.maxCount(banned, n, maxSum));
    }

    @Test
    public void example2() {
        int[] banned = {4, 3, 5, 6};
        int n = 7;
        long maxSum = 18;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2557.maxCount(banned, n, maxSum));
    }
}