import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1705Tests {
    private final Solution1705 solution1705 = new Solution1705();

    @Test
    public void example1() {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution1705.eatenApples(apples, days));
    }

    @Test
    public void example2() {
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution1705.eatenApples(apples, days));
    }
}
