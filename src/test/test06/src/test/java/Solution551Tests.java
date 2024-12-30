import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution551Tests {
    private final Solution551 solution551 = new Solution551();

    @Test
    public void example1() {
        String s = "PPALLP";
        Assertions.assertTrue(solution551.checkRecord(s));
    }

    @Test
    public void example2() {
        String s = "PPALLL";
        Assertions.assertFalse(solution551.checkRecord(s));
    }
}
