import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2525Tests {
    private final Solution2525 solution2525 = new Solution2525();

    @Test
    public void example1() {
        int length = 1000;
        int width = 35;
        int height = 700;
        int mass = 300;
        String expected = "Heavy";
        Assertions.assertEquals(expected, solution2525.categorizeBox(length, width, height, mass));
    }

    @Test
    public void example2() {
        int length = 200;
        int width = 50;
        int height = 800;
        int mass = 50;
        String expected = "Neither";
        Assertions.assertEquals(expected, solution2525.categorizeBox(length, width, height, mass));
    }
}
