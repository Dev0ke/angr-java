import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3340Tests {
    private final Solution3340 solution3340 = new Solution3340();

    @Test
    public void example1() {
        String num = "1234";
        Assertions.assertFalse(solution3340.isBalanced(num));
    }

    @Test
    public void example2() {
        String num = "24123";
        Assertions.assertTrue(solution3340.isBalanced(num));
    }
}