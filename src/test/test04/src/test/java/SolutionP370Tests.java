import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP370Tests {
    private final SolutionP370 solutionP370 = new SolutionP370();

    @Test
    public void example1() {
        int length = 5;
        int[][] updates = UtUtils.stringToInts2("[[1,3,2],[2,4,3],[0,2,-2]]");
        int[] expected = {-2, 0, 3, 5, 3};
        Assertions.assertArrayEquals(expected, solutionP370.getModifiedArray(length, updates));
    }
}
