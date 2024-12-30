import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2037Tests {
    private final Solution2037 solution2037 = new Solution2037();

    @Test
    public void example1() {
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2037.minMovesToSeat(seats, students));
    }

    @Test
    public void example2() {
        int[] seats = {4, 1, 5, 9};
        int[] students = {1, 3, 2, 6};
        int expected = 7;
        Assertions.assertEquals(expected, solution2037.minMovesToSeat(seats, students));
    }

    @Test
    public void example3() {
        int[] seats = {2, 2, 6, 6};
        int[] students = {1, 3, 2, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution2037.minMovesToSeat(seats, students));
    }
}
