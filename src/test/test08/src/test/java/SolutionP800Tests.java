import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP800Tests {
    private final SolutionP800 solutionP800 = new SolutionP800();

    @Test
    public void example1() {
        String color = "#09f166";
        String expected = "#11ee66";
        Assertions.assertEquals(expected, solutionP800.similarRGB(color));
        Assertions.assertEquals(expected, solutionP800.similarRGB2(color));
    }

    @Test
    public void example2() {
        String color = "#4e3fe1";
        String expected = "#5544dd";
        Assertions.assertEquals(expected, solutionP800.similarRGB(color));
        Assertions.assertEquals(expected, solutionP800.similarRGB2(color));
    }
}