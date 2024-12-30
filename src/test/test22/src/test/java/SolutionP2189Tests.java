import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2189Tests {
    private final SolutionP2189 solutionP2189 = new SolutionP2189();

    @Test
    public void example1() {
        int n = 16;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2189.houseOfCards(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2189.houseOfCards(n));
    }

    @Test
    public void example3() {
        int n = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2189.houseOfCards(n));
    }
}