import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3270Tests {
    private final Solution3270 solution3270 = new Solution3270();

    @Test
    public void example1() {
        int num1 = 1;
        int num2 = 10;
        int num3 = 1000;
        int expected = 0;
        Assertions.assertEquals(expected, solution3270.generateKey(num1, num2, num3));
    }

    @Test
    public void example2() {
        int num1 = 987;
        int num2 = 879;
        int num3 = 798;
        int expected = 777;
        Assertions.assertEquals(expected, solution3270.generateKey(num1, num2, num3));
    }

    @Test
    public void example3() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3270.generateKey(num1, num2, num3));
    }
}