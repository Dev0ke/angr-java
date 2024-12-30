import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3280Tests {
    private final Solution3280 solution3280 = new Solution3280();

    @Test
    public void example1() {
        String date = "2080-02-29";
        String expected = "100000100000-10-11101";
        Assertions.assertEquals(expected, solution3280.convertDateToBinary(date));
    }

    @Test
    public void example2() {
        String date = "1900-01-01";
        String expected = "11101101100-1-1";
        Assertions.assertEquals(expected, solution3280.convertDateToBinary(date));
    }
}