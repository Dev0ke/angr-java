import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1087Tests {
    private final SolutionP1087 solutionP1087 = new SolutionP1087();

    @Test
    public void example1() {
        String s = "{a,b}c{d,e}f";
        String[] expected = {"acdf", "acef", "bcdf", "bcef"};
        Assertions.assertArrayEquals(expected, solutionP1087.expand(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String[] expected = {"abcd"};
        Assertions.assertArrayEquals(expected, solutionP1087.expand(s));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "{a,b}{z,x,y}";
        String[] expected = {"ax", "ay", "az", "bx", "by", "bz"};
        Assertions.assertArrayEquals(expected, solutionP1087.expand(s));
    }
}
