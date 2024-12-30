import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2938Tests {
    private final Solution2938 solution2938 = new Solution2938();

    @Test
    public void example1() {
        String s = "101";
        long expected = 1;
        Assertions.assertEquals(expected, solution2938.minimumSteps(s));
        Assertions.assertEquals(expected, solution2938.minimumSteps2(s));
    }

    @Test
    public void example2() {
        String s = "100";
        long expected = 2;
        Assertions.assertEquals(expected, solution2938.minimumSteps(s));
        Assertions.assertEquals(expected, solution2938.minimumSteps2(s));
    }

    @Test
    public void example3() {
        String s = "0111";
        long expected = 0;
        Assertions.assertEquals(expected, solution2938.minimumSteps(s));
        Assertions.assertEquals(expected, solution2938.minimumSteps2(s));
    }
}