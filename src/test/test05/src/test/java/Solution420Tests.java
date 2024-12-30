import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution420Tests {
    private final Solution420 solution420 = new Solution420();

    @Test
    public void example1() {
        String password = "a";
        int expected = 5;
        Assertions.assertEquals(expected, solution420.strongPasswordChecker(password));
    }

    @Test
    public void example2() {
        String password = "aA1";
        int expected = 3;
        Assertions.assertEquals(expected, solution420.strongPasswordChecker(password));
    }

    @Test
    public void example3() {
        String password = "1337C0d3";
        int expected = 0;
        Assertions.assertEquals(expected, solution420.strongPasswordChecker(password));
    }
}