import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP484Tests {
    private final SolutionP484 solutionP484 = new SolutionP484();

    @Test
    public void example1() {
        String s = "I";
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solutionP484.findPermutation(s));
    }

    @Test
    public void example2() {
        String s = "DI";
        int[] expected = {2, 1, 3};
        Assertions.assertArrayEquals(expected, solutionP484.findPermutation(s));
    }
}
