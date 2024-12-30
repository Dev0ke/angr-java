import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2355Tests {
    private final SolutionP2355 solutionP2355 = new SolutionP2355();

    @Test
    public void example1() {
        int[] books = {8, 5, 2, 7, 9};
        long expected = 19;
        Assertions.assertEquals(expected, solutionP2355.maximumBooks(books));
    }

    @Test
    public void example2() {
        int[] books = {7, 0, 3, 4, 5};
        long expected = 12;
        Assertions.assertEquals(expected, solutionP2355.maximumBooks(books));
    }

    @Test
    public void example3() {
        int[] books = {8, 2, 3, 7, 3, 4, 0, 1, 4, 3};
        long expected = 13;
        Assertions.assertEquals(expected, solutionP2355.maximumBooks(books));
    }
}