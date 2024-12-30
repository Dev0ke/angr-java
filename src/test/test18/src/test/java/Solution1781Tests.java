import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1781Tests {
    private final Solution1781 solution1781 = new Solution1781();

    @Test
    public void example1() {
        String s = "aabcb";
        int expected = 5;
        Assertions.assertEquals(expected, solution1781.beautySum(s));
    }

    @Test
    public void example2() {
        String s = "aabcbaa";
        int expected = 17;
        Assertions.assertEquals(expected, solution1781.beautySum(s));
    }
}
