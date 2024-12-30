import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1871Tests {
    private final Solution1871 solution1871 = new Solution1871();

    @Test
    public void example1() {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        Assertions.assertTrue(solution1871.canReach(s, minJump, maxJump));
    }

    @Test
    public void example2() {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        Assertions.assertFalse(solution1871.canReach(s, minJump, maxJump));
    }
}