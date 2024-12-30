import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution959Tests {
    private final Solution959 solution959 = new Solution959();

    @Test
    public void example1() {
        String[] grid = {" /", "/ "};
        int expected = 2;
        Assertions.assertEquals(expected, solution959.regionsBySlashes(grid));
    }

    @Test
    public void example2() {
        String[] grid = {" /", "  "};
        int expected = 1;
        Assertions.assertEquals(expected, solution959.regionsBySlashes(grid));
    }

    @Test
    public void example3() {
        String[] grid = {"/\\", "\\/"};
        int expected = 5;
        Assertions.assertEquals(expected, solution959.regionsBySlashes(grid));
    }
}