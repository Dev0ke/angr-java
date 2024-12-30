import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution135Tests {
    private final Solution135 solution135 = new Solution135();

    @Test
    public void example1() {
        int[] ratings = {1, 0, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution135.candy(ratings));
    }

    @Test
    public void example2() {
        int[] ratings = {1, 2, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution135.candy(ratings));
    }
}
