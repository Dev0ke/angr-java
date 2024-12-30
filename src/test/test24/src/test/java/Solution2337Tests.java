import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2337Tests {
    private final Solution2337 solution2337 = new Solution2337();

    @Test
    public void example1() {
        String start = "_L__R__R_";
        String target = "L______RR";
        Assertions.assertTrue(solution2337.canChange(start, target));
    }

    @Test
    public void example2() {
        String start = "R_L_";
        String target = "__LR";
        Assertions.assertFalse(solution2337.canChange(start, target));
    }

    @Test
    public void example3() {
        String start = "_R";
        String target = "R_";
        Assertions.assertFalse(solution2337.canChange(start, target));
    }
}
