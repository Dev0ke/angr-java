import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP683Tests {
    private final SolutionP683 solutionP683 = new SolutionP683();

    @Test
    public void example1() {
        int[] bulbs = {1, 3, 2};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP683.kEmptySlots(bulbs, k));
        Assertions.assertEquals(expected, solutionP683.kEmptySlots2(bulbs, k));
    }

    @Test
    public void example2() {
        int[] bulbs = {1, 2, 3};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP683.kEmptySlots(bulbs, k));
        Assertions.assertEquals(expected, solutionP683.kEmptySlots2(bulbs, k));
    }
}