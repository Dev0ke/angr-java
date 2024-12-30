import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution983Tests {
    private final Solution983 solution983 = new Solution983();

    @Test
    public void example1() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int expected = 11;
        Assertions.assertEquals(expected, solution983.mincostTickets(days, costs));
    }

    @Test
    public void example2() {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        int expected = 17;
        Assertions.assertEquals(expected, solution983.mincostTickets(days, costs));
    }
}
