import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution670Tests {
    private final Solution670 solution670 = new Solution670();

    @Test
    public void example1() {
        int num = 2736;
        int expected = 7236;
        Assertions.assertEquals(expected, solution670.maximumSwap(num));
    }

    @Test
    public void example2() {
        int num = 9973;
        int expected = 9973;
        Assertions.assertEquals(expected, solution670.maximumSwap(num));
    }
}
