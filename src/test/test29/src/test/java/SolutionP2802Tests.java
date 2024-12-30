import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2802Tests {
    private final SolutionP2802 solutionP2802 = new SolutionP2802();

    @Test
    public void example1() {
        int k = 4;
        String expected = "47";
        Assertions.assertEquals(expected, solutionP2802.kthLuckyNumber(k));
    }

    @Test
    public void example2() {
        int k = 10;
        String expected = "477";
        Assertions.assertEquals(expected, solutionP2802.kthLuckyNumber(k));
    }

    @Test
    public void example3() {
        int k = 1000;
        String expected = "777747447";
        Assertions.assertEquals(expected, solutionP2802.kthLuckyNumber(k));
    }
}