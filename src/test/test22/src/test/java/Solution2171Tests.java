import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2171Tests {
    private final Solution2171 solution2171 = new Solution2171();

    @Test
    public void example1() {
        int[] beans = {4, 1, 6, 5};
        long expected = 4;
        Assertions.assertEquals(expected, solution2171.minimumRemoval(beans));
    }

    @Test
    public void example2() {
        int[] beans = {2, 10, 3, 2};
        long expected = 7;
        Assertions.assertEquals(expected, solution2171.minimumRemoval(beans));
    }
}
