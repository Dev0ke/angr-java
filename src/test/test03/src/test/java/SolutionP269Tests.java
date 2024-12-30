import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP269Tests {
    private final SolutionP269 solutionP269 = new SolutionP269();

    @Test
    public void example1() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String expected = "wertf";
        Assertions.assertEquals(expected, solutionP269.alienOrder(words));
    }

    @Test
    public void example2() {
        String[] words = {"z", "x"};
        String expected = "zx";
        Assertions.assertEquals(expected, solutionP269.alienOrder(words));
    }

    @Test
    public void example3() {
        String[] words = {"z", "x", "z"};
        String expected = "";
        Assertions.assertEquals(expected, solutionP269.alienOrder(words));
    }
}
