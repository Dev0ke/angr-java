import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3343Tests {
    private final Solution3343 solution3343 = new Solution3343();

    @Test
    public void example1() {
        String num = "123";
        int expected = 2;
        Assertions.assertEquals(expected, solution3343.countBalancedPermutations(num));
    }

    @Test
    public void example2() {
        String num = "112";
        int expected = 1;
        Assertions.assertEquals(expected, solution3343.countBalancedPermutations(num));
    }

    @Test
    public void example3() {
        String num = "12345";
        int expected = 0;
        Assertions.assertEquals(expected, solution3343.countBalancedPermutations(num));
    }
}