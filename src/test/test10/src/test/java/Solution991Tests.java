import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution991Tests {
    private final Solution991 solution991 = new Solution991();

    @Test
    public void example1() {
        int startValue = 2;
        int target = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution991.brokenCalc(startValue, target));
    }

    @Test
    public void example2() {
        int startValue = 5;
        int target = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solution991.brokenCalc(startValue, target));
    }

    @Test
    public void example3() {
        int startValue = 3;
        int target = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution991.brokenCalc(startValue, target));
    }
}