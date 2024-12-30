import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2645Tests {
    private final Solution2645 solution2645 = new Solution2645();

    @Test
    public void example1() {
        String word = "b";
        int expected = 2;
        Assertions.assertEquals(expected, solution2645.addMinimum(word));
        Assertions.assertEquals(expected, solution2645.addMinimum2(word));
    }

    @Test
    public void example2() {
        String word = "aaa";
        int expected = 6;
        Assertions.assertEquals(expected, solution2645.addMinimum(word));
        Assertions.assertEquals(expected, solution2645.addMinimum2(word));
    }

    @Test
    public void example3() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution2645.addMinimum(word));
        Assertions.assertEquals(expected, solution2645.addMinimum2(word));
    }
}