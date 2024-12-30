import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2391Tests {
    private final Solution2391 solution2391 = new Solution2391();

    @Test
    public void example1() {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        int expected = 21;
        Assertions.assertEquals(expected, solution2391.garbageCollection(garbage, travel));
    }

    @Test
    public void example2() {
        String[] garbage = {"MMM", "PGM", "GP"};
        int[] travel = {3, 10};
        int expected = 37;
        Assertions.assertEquals(expected, solution2391.garbageCollection(garbage, travel));
    }
}
