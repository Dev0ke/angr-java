import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1055Tests {
    private final SolutionP1055 solutionP1055 = new SolutionP1055();

    @Test
    public void example1() {
        String source = "abc";
        String target = "abcbc";
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1055.shortestWay(source, target));
    }

    @Test
    public void example2() {
        String source = "abc";
        String target = "acdbc";
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1055.shortestWay(source, target));
    }

    @Test
    public void example3() {
        String source = "xyz";
        String target = "xzyxz";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1055.shortestWay(source, target));
    }

    // 补充用例
    @Test
    public void example4() {
        String source = "aaaaa";
        String target = "aaaaaaaaaaaaa";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1055.shortestWay(source, target));
    }
}