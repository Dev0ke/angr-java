import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2413Tests {
    private final Solution2413 solution2413 = new Solution2413();

    @Test
    public void example1() {
        int n = 5;
        int expected = 10;
        Assertions.assertEquals(expected, solution2413.smallestEvenMultiple(n));
        Assertions.assertEquals(expected, solution2413.smallestEvenMultiple2(n));
    }

    @Test
    public void example2() {
        int n = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution2413.smallestEvenMultiple(n));
        Assertions.assertEquals(expected, solution2413.smallestEvenMultiple2(n));
    }
}
