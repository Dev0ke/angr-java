import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2698Tests {
    private final Solution2698 solution2698 = new Solution2698();

    @Test
    public void example1() {
        int n = 10;
        int expected = 182;
        Assertions.assertEquals(expected, solution2698.punishmentNumber(n));
    }

    @Test
    public void example2() {
        int n = 37;
        int expected = 1478;
        Assertions.assertEquals(expected, solution2698.punishmentNumber(n));
    }
}