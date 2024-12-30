import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1796Tests {
    private final Solution1796 solution1796 = new Solution1796();

    @Test
    public void example1() {
        String s = "dfa12321afd";
        int expected = 2;
        Assertions.assertEquals(expected, solution1796.secondHighest(s));
    }

    @Test
    public void example2() {
        String s = "abc1111";
        int expected = -1;
        Assertions.assertEquals(expected, solution1796.secondHighest(s));
    }
}
