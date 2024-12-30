import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2299Tests {
    private final Solution2299 solution2299 = new Solution2299();

    @Test
    public void example1() {
        String password = "IloveLe3tcode!";
        Assertions.assertTrue(solution2299.strongPasswordCheckerII(password));
    }

    @Test
    public void example2() {
        String password = "Me+You--IsMyDream";
        Assertions.assertFalse(solution2299.strongPasswordCheckerII(password));
    }

    @Test
    public void example3() {
        String password = "1aB!";
        Assertions.assertFalse(solution2299.strongPasswordCheckerII(password));
    }
}
