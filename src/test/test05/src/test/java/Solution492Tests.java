import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution492Tests {
    private final Solution492 solution492 = new Solution492();

    @Test
    public void example1() {
        int area = 4;
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution492.constructRectangle(area));
    }
}
