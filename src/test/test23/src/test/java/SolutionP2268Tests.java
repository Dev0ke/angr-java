import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2268Tests {
    private final SolutionP2268 solutionP2268 = new SolutionP2268();

    @Test
    public void example1() {
        String s = "apple";
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2268.minimumKeypresses(s));
    }

    @Test
    public void example2() {
        String s = "abcdefghijkl";
        int expected = 15;
        Assertions.assertEquals(expected, solutionP2268.minimumKeypresses(s));
    }
}