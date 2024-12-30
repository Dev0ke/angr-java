import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution790Tests {
    private final Solution790 solution790 = new Solution790();

    @Test
    public void example1() {
        int n = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution790.numTilings(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution790.numTilings(n));
    }
}
