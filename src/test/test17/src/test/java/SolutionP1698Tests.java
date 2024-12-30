import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1698Tests {
    private final SolutionP1698.V1 solutionP1698_v1 = new SolutionP1698.V1();
    private final SolutionP1698.V2 solutionP1698_v2 = new SolutionP1698.V2();

    @Test
    public void example1() {
        String s = "aabbaba";
        int expected = 21;
        Assertions.assertEquals(expected, solutionP1698_v1.countDistinct(s));
        Assertions.assertEquals(expected, solutionP1698_v2.countDistinct(s));
    }

    @Test
    public void example2() {
        String s = "abcdefg";
        int expected = 28;
        Assertions.assertEquals(expected, solutionP1698_v1.countDistinct(s));
        Assertions.assertEquals(expected, solutionP1698_v2.countDistinct(s));
    }
}