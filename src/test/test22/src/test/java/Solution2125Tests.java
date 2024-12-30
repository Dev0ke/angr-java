import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2125Tests {
    private final Solution2125 solution2125 = new Solution2125();

    @Test
    public void example1() {
        String[] bank = {"011001", "000000", "010100", "001000"};
        int expected = 8;
        Assertions.assertEquals(expected, solution2125.numberOfBeams(bank));
    }

    @Test
    public void example2() {
        String[] bank = {"000", "111", "000"};
        int expected = 0;
        Assertions.assertEquals(expected, solution2125.numberOfBeams(bank));
    }
}
