import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1716Tests {
    private final Solution1716 solution1716 = new Solution1716();

    @Test
    public void example1() {
        int n = 4;
        int expected = 10;
        Assertions.assertEquals(expected, solution1716.totalMoney(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 37;
        Assertions.assertEquals(expected, solution1716.totalMoney(n));
    }

    @Test
    public void example3() {
        int n = 20;
        int expected = 96;
        Assertions.assertEquals(expected, solution1716.totalMoney(n));
    }
}
