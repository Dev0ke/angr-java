import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1954Tests {
    private final Solution1954 solution1954 = new Solution1954();

    @Test
    public void example1() {
        long neededApples = 1;
        long expected = 8;
        Assertions.assertEquals(expected, solution1954.minimumPerimeter(neededApples));
        Assertions.assertEquals(expected, solution1954.minimumPerimeter2(neededApples));
    }

    @Test
    public void example2() {
        long neededApples = 13;
        long expected = 16;
        Assertions.assertEquals(expected, solution1954.minimumPerimeter(neededApples));
        Assertions.assertEquals(expected, solution1954.minimumPerimeter2(neededApples));
    }

    @Test
    public void example3() {
        long neededApples = 1000000000;
        long expected = 5040;
        Assertions.assertEquals(expected, solution1954.minimumPerimeter(neededApples));
        Assertions.assertEquals(expected, solution1954.minimumPerimeter2(neededApples));
    }
}
