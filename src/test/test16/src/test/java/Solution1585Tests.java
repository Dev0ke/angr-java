import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1585Tests {
    private final Solution1585 solution1585 = new Solution1585();

    @Test
    public void example1() {
        String s = "84532";
        String t = "34852";
        Assertions.assertTrue(solution1585.isTransformable(s, t));
    }

    @Test
    public void example2() {
        String s = "34521";
        String t = "23415";
        Assertions.assertTrue(solution1585.isTransformable(s, t));
    }

    @Test
    public void example3() {
        String s = "12345";
        String t = "12435";
        Assertions.assertFalse(solution1585.isTransformable(s, t));
    }

    @Test
    public void example4() {
        String s = "1";
        String t = "2";
        Assertions.assertFalse(solution1585.isTransformable(s, t));
    }
}