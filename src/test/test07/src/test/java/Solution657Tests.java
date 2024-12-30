import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution657Tests {
    private final Solution657 solution657 = new Solution657();

    @Test
    public void example1() {
        String moves = "UD";
        Assertions.assertTrue(solution657.judgeCircle(moves));
    }

    @Test
    public void example2() {
        String moves = "LL";
        Assertions.assertFalse(solution657.judgeCircle(moves));
    }
}
