import org.junit.jupiter.api.Test;

public class SolutionP1618Tests {
    private final SolutionP1618 solutionP1618 = new SolutionP1618();

    @Test
    public void example1() {
        String text = "helloworld";
        int w = 80;
        int h = 20;
        int[] fonts = {6, 8, 10, 12, 14, 16, 18, 24, 36};
        int expected = 6;
    }

    @Test
    public void example2() {
        String text = "leetcode";
        int w = 1000;
        int h = 50;
        int[] fonts = {1, 2, 4};
        int expected = 4;
    }

    @Test
    public void example3() {
        String text = "easyquestion";
        int w = 100;
        int h = 100;
        int[] fonts = {10, 15, 20, 25};
        int expected = -1;
    }
}
