import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1552Tests {
    private final Solution1552 solution1552 = new Solution1552();

    @Test
    public void example1() {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1552.maxDistance(position, m));
    }

    @Test
    public void example2() {
        int[] position = {5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        int expected = 999999999;
        Assertions.assertEquals(expected, solution1552.maxDistance(position, m));
    }
}
