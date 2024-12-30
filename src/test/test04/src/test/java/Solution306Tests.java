import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution306Tests {
    private final Solution306 solution306 = new Solution306();

    @Test
    public void example1() {
        String num = "112358";
        Assertions.assertTrue(solution306.isAdditiveNumber(num));
    }

    @Test
    public void example2() {
        String num = "199100199";
        Assertions.assertTrue(solution306.isAdditiveNumber(num));
    }
}