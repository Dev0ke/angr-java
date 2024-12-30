import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2591Tests {
    private final Solution2591 solution2591 = new Solution2591();

    @Test
    public void example1() {
        int money = 20;
        int children = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution2591.distMoney(money, children));
    }

    @Test
    public void example2() {
        int money = 16;
        int children = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2591.distMoney(money, children));
    }
}