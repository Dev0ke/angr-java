import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3206Tests {
    private final Solution3206 solution3206 = new Solution3206();

    @Test
    public void example1() {
        int[] colors = {1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3206.numberOfAlternatingGroups(colors));
    }

    @Test
    public void example2() {
        int[] colors = {0, 1, 0, 0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3206.numberOfAlternatingGroups(colors));
    }
}