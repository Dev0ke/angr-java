import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution860Tests {
    private final Solution860 solution860 = new Solution860();

    @Test
    public void example1() {
        int[] bills = {5, 5, 5, 10, 20};
        Assertions.assertTrue(solution860.lemonadeChange(bills));
    }

    @Test
    public void example2() {
        int[] bills = {5, 5, 10};
        Assertions.assertTrue(solution860.lemonadeChange(bills));
    }

    @Test
    public void example3() {
        int[] bills = {10, 10};
        Assertions.assertFalse(solution860.lemonadeChange(bills));
    }

    @Test
    public void example4() {
        int[] bills = {5, 5, 10, 10, 20};
        Assertions.assertFalse(solution860.lemonadeChange(bills));
    }
}
