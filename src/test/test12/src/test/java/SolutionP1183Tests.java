import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1183Tests {
    private final SolutionP1183 solutionP1183 = new SolutionP1183();

    @Test
    public void example1() {
        int width = 3;
        int height = 3;
        int sideLength = 2;
        int maxOnes = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1183.maximumNumberOfOnes(width, height, sideLength, maxOnes));
    }

    @Test
    public void example2() {
        int width = 3;
        int height = 3;
        int sideLength = 2;
        int maxOnes = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1183.maximumNumberOfOnes(width, height, sideLength, maxOnes));
    }
}