import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2514Tests {
    private final Solution2514 solution2514 = new Solution2514();

    @Test
    public void example1() {
        String s = "too hot";
        int expected = 18;
        Assertions.assertEquals(expected, solution2514.countAnagrams(s));
    }

    @Test
    public void example2() {
        String s = "aa";
        int expected = 1;
        Assertions.assertEquals(expected, solution2514.countAnagrams(s));
    }
}
