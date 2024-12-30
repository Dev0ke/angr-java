import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1271Tests {
    private final SolutionP1271 solutionP1271 = new SolutionP1271();

    @Test
    public void example1() {
        String num = "257";
        String expected = "IOI";
        Assertions.assertEquals(expected, solutionP1271.toHexspeak(num));
    }

    @Test
    public void example2() {
        String num = "3";
        String expected = "ERROR";
        Assertions.assertEquals(expected, solutionP1271.toHexspeak(num));
    }
}