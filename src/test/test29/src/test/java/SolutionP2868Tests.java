import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2868Tests {
    private final SolutionP2868 solutionP2868 = new SolutionP2868();

    @Test
    public void example1() {
        String[] a = {"avokado", "dabar"};
        String[] b = {"brazil"};
        Assertions.assertFalse(solutionP2868.canAliceWin(a, b));
    }

    @Test
    public void example2() {
        String[] a = {"ananas", "atlas", "banana"};
        String[] b = {"albatros", "cikla", "nogomet"};
        Assertions.assertTrue(solutionP2868.canAliceWin(a, b));
    }

    @Test
    public void example3() {
        String[] a = {"hrvatska", "zastava"};
        String[] b = {"bijeli", "galeb"};
        Assertions.assertTrue(solutionP2868.canAliceWin(a, b));
    }
}