import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1041Tests {
    private final Solution1041 solution1041 = new Solution1041();

    @Test
    public void example1() {
        String instructions = "GGLLGG";
        Assertions.assertTrue(solution1041.isRobotBounded(instructions));
    }

    @Test
    public void example2() {
        String instructions = "GG";
        Assertions.assertFalse(solution1041.isRobotBounded(instructions));
    }

    @Test
    public void example3() {
        String instructions = "GL";
        Assertions.assertTrue(solution1041.isRobotBounded(instructions));
    }
}