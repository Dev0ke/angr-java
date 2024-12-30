import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3335Tests {
    private final Solution3335 solution3335 = new Solution3335();

    @Test
    public void example1() {
        String s = "abcyy";
        int t = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution3335.lengthAfterTransformations(s, t));
    }

    @Test
    public void example2() {
        String s = "azbk";
        int t = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution3335.lengthAfterTransformations(s, t));
    }
}