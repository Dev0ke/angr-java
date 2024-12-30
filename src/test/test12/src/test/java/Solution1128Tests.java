import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1128Tests {
    private final Solution1128 solution1128 = new Solution1128();

    @Test
    public void example1() {
        int[][] dominoes = UtUtils.stringToInts2("[[1,2],[2,1],[3,4],[5,6]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1128.numEquivDominoPairs(dominoes));
    }

    @Test
    public void example2() {
        int[][] dominoes = UtUtils.stringToInts2("[[1,2],[1,2],[1,1],[1,2],[2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1128.numEquivDominoPairs(dominoes));
    }
}