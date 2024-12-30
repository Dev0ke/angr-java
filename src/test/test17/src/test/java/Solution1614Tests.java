import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1614Tests {
    private final Solution1614 solution1614 = new Solution1614();

    @Test
    public void example1() {
        String s = "(1+(2*3)+((8)/4))+1";
        int expected = 3;
        Assertions.assertEquals(expected, solution1614.maxDepth(s));
    }

    @Test
    public void example2() {
        String s = "(1)+((2))+(((3)))";
        int expected = 3;
        Assertions.assertEquals(expected, solution1614.maxDepth(s));
    }

    @Test
    public void example3() {
        String s = "1+(2*3)/(2-1)";
        int expected = 1;
        Assertions.assertEquals(expected, solution1614.maxDepth(s));
    }

    @Test
    public void example4() {
        String s = "1";
        int expected = 0;
        Assertions.assertEquals(expected, solution1614.maxDepth(s));
    }
}
