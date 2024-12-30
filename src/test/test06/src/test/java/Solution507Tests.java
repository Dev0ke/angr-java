import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution507Tests {
    private final Solution507 solution507 = new Solution507();

    @Test
    public void example1() {
        int num = 28;
        Assertions.assertTrue(solution507.checkPerfectNumber(num));
        Assertions.assertTrue(solution507.checkPerfectNumber2(num));
    }

    @Test
    public void example2() {
        int num = 6;
        Assertions.assertTrue(solution507.checkPerfectNumber(num));
        Assertions.assertTrue(solution507.checkPerfectNumber2(num));
    }

    @Test
    public void example3() {
        int num = 496;
        Assertions.assertTrue(solution507.checkPerfectNumber(num));
        Assertions.assertTrue(solution507.checkPerfectNumber2(num));
    }

    @Test
    public void example4() {
        int num = 8128;
        Assertions.assertTrue(solution507.checkPerfectNumber(num));
        Assertions.assertTrue(solution507.checkPerfectNumber2(num));
    }

    @Test
    public void example5() {
        int num = 2;
        Assertions.assertFalse(solution507.checkPerfectNumber(num));
        Assertions.assertFalse(solution507.checkPerfectNumber2(num));
    }
}
