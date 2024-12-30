import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1790Tests {
    private final Solution1790 solution1790 = new Solution1790();

    @Test
    public void example1() {
        String s1 = "bank";
        String s2 = "kanb";
        Assertions.assertTrue(solution1790.areAlmostEqual(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "attack";
        String s2 = "defend";
        Assertions.assertFalse(solution1790.areAlmostEqual(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "kelb";
        String s2 = "kelb";
        Assertions.assertTrue(solution1790.areAlmostEqual(s1, s2));
    }

    @Test
    public void example4() {
        String s1 = "abcd";
        String s2 = "dcba";
        Assertions.assertFalse(solution1790.areAlmostEqual(s1, s2));
    }
}
