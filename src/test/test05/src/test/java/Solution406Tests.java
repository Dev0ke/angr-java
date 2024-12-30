import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution406Tests {
    private final Solution406 solution406 = new Solution406();

    @Test
    public void example1() {
        int[][] people = UtUtils.stringToInts2("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]");
        int[][] expected = UtUtils.stringToInts2("[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]");
        Assertions.assertArrayEquals(expected, solution406.reconstructQueue(people));
    }

    @Test
    public void example2() {
        int[][] people = UtUtils.stringToInts2("[[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]");
        int[][] expected = UtUtils.stringToInts2("[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]");
        Assertions.assertArrayEquals(expected, solution406.reconstructQueue(people));
    }
}
