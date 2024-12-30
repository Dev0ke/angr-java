import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3200Tests {
    private final Solution3200 solution3200 = new Solution3200();

    @Test
    public void example1() {
        int red = 2;
        int blue = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3200.maxHeightOfTriangle(red, blue));
    }

    @Test
    public void example2() {
        int red = 2;
        int blue = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3200.maxHeightOfTriangle(red, blue));
    }

    @Test
    public void example3() {
        int red = 1;
        int blue = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3200.maxHeightOfTriangle(red, blue));
    }

    @Test
    public void example4() {
        int red = 10;
        int blue = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3200.maxHeightOfTriangle(red, blue));
    }
}