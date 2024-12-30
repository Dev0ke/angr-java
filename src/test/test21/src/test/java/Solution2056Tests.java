import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2056Tests {
    private final Solution2056 solution2056 = new Solution2056();

    @Test
    public void example1() {
        String[] pieces = {"rook"};
        int[][] positions = UtUtils.stringToInts2("[[1,1]]");
        int expected = 15;
        Assertions.assertEquals(expected, solution2056.countCombinations(pieces, positions));
    }

    @Test
    public void example2() {
        String[] pieces = {"queen"};
        int[][] positions = UtUtils.stringToInts2("[[1,1]]");
        int expected = 22;
        Assertions.assertEquals(expected, solution2056.countCombinations(pieces, positions));
    }

    @Test
    public void example3() {
        String[] pieces = {"bishop"};
        int[][] positions = UtUtils.stringToInts2("[[4,3]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution2056.countCombinations(pieces, positions));
    }

    @Test
    public void example4() {
        String[] pieces = {"rook", "rook"};
        int[][] positions = UtUtils.stringToInts2("[[1,1],[8,8]]");
        int expected = 223;
        Assertions.assertEquals(expected, solution2056.countCombinations(pieces, positions));
    }

    @Test
    public void example5() {
        String[] pieces = {"queen", "bishop"};
        int[][] positions = UtUtils.stringToInts2("[[5,7],[3,4]]");
        int expected = 281;
        Assertions.assertEquals(expected, solution2056.countCombinations(pieces, positions));
    }
}