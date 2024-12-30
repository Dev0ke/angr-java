import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1842Tests {
    private final SolutionP1842 solutionP1842 = new SolutionP1842();

    @Test
    public void example1() {
        String num = "1221";
        String expected = "2112";
        Assertions.assertEquals(expected, solutionP1842.nextPalindrome(num));
    }

    @Test
    public void example2() {
        String num = "32123";
        String expected = "";
        Assertions.assertEquals(expected, solutionP1842.nextPalindrome(num));
    }

    @Test
    public void example3() {
        String num = "45544554";
        String expected = "54455445";
        Assertions.assertEquals(expected, solutionP1842.nextPalindrome(num));
    }
}