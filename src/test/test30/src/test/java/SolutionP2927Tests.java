import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2927Tests {
    private final SolutionP2927 solutionP2927 = new SolutionP2927();

    @Test
    public void example1() {
        int n = 5;
        int limit = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP2927.distributeCandies(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int limit = 3;
        long expected = 10;
        Assertions.assertEquals(expected, solutionP2927.distributeCandies(n, limit));
    }
}