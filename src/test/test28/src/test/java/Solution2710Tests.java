import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2710Tests {
    private final Solution2710 solution2710 = new Solution2710();

    @Test
    public void example1() {
        String num = "51230100";
        String expected = "512301";
        Assertions.assertEquals(expected, solution2710.removeTrailingZeros(num));
    }

    @Test
    public void example2() {
        String num = "123";
        String expected = "123";
        Assertions.assertEquals(expected, solution2710.removeTrailingZeros(num));
    }
}