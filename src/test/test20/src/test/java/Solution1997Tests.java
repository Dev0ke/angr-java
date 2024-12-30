import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1997Tests {
    private final Solution1997 solution1997 = new Solution1997();

    @Test
    public void example1() {
        int[] nextVisit = {0, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution1997.firstDayBeenInAllRooms(nextVisit));
    }

    @Test
    public void example2() {
        int[] nextVisit = {0, 0, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution1997.firstDayBeenInAllRooms(nextVisit));
    }

    @Test
    public void example3() {
        int[] nextVisit = {0, 1, 2, 0};
        int expected = 6;
        Assertions.assertEquals(expected, solution1997.firstDayBeenInAllRooms(nextVisit));
    }
}
