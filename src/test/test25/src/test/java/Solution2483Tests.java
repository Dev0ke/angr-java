import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2483Tests {
    private final Solution2483 solution2483 = new Solution2483();

    @Test
    public void example1() {
        String customers = "YYNY";
        int expected = 2;
        Assertions.assertEquals(expected, solution2483.bestClosingTime(customers));
    }

    @Test
    public void example2() {
        String customers = "NNNNN";
        int expected = 0;
        Assertions.assertEquals(expected, solution2483.bestClosingTime(customers));
    }

    @Test
    public void example3() {
        String customers = "YYYY";
        int expected = 4;
        Assertions.assertEquals(expected, solution2483.bestClosingTime(customers));
    }
}
