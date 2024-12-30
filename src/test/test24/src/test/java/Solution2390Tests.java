import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2390Tests {
    private final Solution2390 solution2390 = new Solution2390();

    @Test
    public void example1() {
        String s = "leet**cod*e";
        String expected = "lecoe";
        Assertions.assertEquals(expected, solution2390.removeStars(s));
    }

    @Test
    public void example2() {
        String s = "erase*****";
        String expected = "";
        Assertions.assertEquals(expected, solution2390.removeStars(s));
    }
}
