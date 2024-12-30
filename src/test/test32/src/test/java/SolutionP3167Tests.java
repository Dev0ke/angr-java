import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3167Tests {
    private final SolutionP3167 solutionP3167 = new SolutionP3167();

    @Test
    public void example1() {
        String compressed = "a3c9b2c1";
        String expected = "a3b2c10";
        Assertions.assertEquals(expected, solutionP3167.betterCompression(compressed));
    }

    @Test
    public void example2() {
        String compressed = "c2b3a1";
        String expected = "a1b3c2";
        Assertions.assertEquals(expected, solutionP3167.betterCompression(compressed));
    }

    @Test
    public void example3() {
        String compressed = "a2b4c1";
        String expected = "a2b4c1";
        Assertions.assertEquals(expected, solutionP3167.betterCompression(compressed));
    }
}