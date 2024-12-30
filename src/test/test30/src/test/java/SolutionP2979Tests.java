import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2979Tests {
    private final SolutionP2979 solutionP2979 = new SolutionP2979();

    @Test
    public void example1() {
        int primeOne = 2;
        int primeTwo = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2979.mostExpensiveItem(primeOne, primeTwo));
    }

    @Test
    public void example2() {
        int primeOne = 5;
        int primeTwo = 7;
        int expected = 23;
        Assertions.assertEquals(expected, solutionP2979.mostExpensiveItem(primeOne, primeTwo));
    }
}