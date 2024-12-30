import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2745Tests {
    private final Solution2745 solution2745 = new Solution2745();

    @Test
    public void example1() {
        int x = 2;
        int y = 5;
        int z = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution2745.longestString(x, y, z));
    }

    @Test
    public void example2() {
        int x = 3;
        int y = 2;
        int z = 2;
        int expected = 14;
        Assertions.assertEquals(expected, solution2745.longestString(x, y, z));
    }
}