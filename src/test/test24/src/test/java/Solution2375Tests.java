import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2375Tests {
    private final Solution2375 solution2375 = new Solution2375();

    @Test
    public void example1() {
        String pattern = "IIIDIDDD";
        String expected = "123549876";
        Assertions.assertEquals(expected, solution2375.smallestNumber(pattern));
    }

    @Test
    public void example2() {
        String pattern = "DDD";
        String expected = "4321";
        Assertions.assertEquals(expected, solution2375.smallestNumber(pattern));
    }
}
