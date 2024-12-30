import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1395Tests {
    private final Solution1395 solution1395 = new Solution1395();

    @Test
    public void example1() {
        int[] rating = {2, 5, 3, 4, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1395.numTeams(rating));
    }

    @Test
    public void example2() {
        int[] rating = {2, 1, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1395.numTeams(rating));
    }

    @Test
    public void example3() {
        int[] rating = {1, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution1395.numTeams(rating));
    }
}