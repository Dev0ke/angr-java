import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3136Tests {
    private final Solution3136 solution3136 = new Solution3136();

    @Test
    public void example1() {
        String word = "234Adas";
        Assertions.assertTrue(solution3136.isValid(word));
    }

    @Test
    public void example2() {
        String word = "b3";
        Assertions.assertFalse(solution3136.isValid(word));
    }

    @Test
    public void example3() {
        String word = "a3$e";
        Assertions.assertFalse(solution3136.isValid(word));
    }
}