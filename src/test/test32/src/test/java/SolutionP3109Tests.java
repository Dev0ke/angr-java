import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3109Tests {
    private final SolutionP3109 solutionP3109 = new SolutionP3109();

    @Test
    public void example1() {
        int[] perm = {1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3109.getPermutationIndex(perm));
    }

    @Test
    public void example2() {
        int[] perm = {3, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3109.getPermutationIndex(perm));
    }
}