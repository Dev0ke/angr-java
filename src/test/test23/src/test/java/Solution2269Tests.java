import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2269Tests {
    private final Solution2269 solution2269 = new Solution2269();

    @Test
    public void example1() {
        int num = 240;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2269.divisorSubstrings(num, k));
    }

    @Test
    public void example2() {
        int num = 430043;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2269.divisorSubstrings(num, k));
    }
}
