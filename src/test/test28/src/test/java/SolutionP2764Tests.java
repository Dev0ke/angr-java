import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2764Tests {
    private final SolutionP2764 solutionP2764 = new SolutionP2764();

    @Test
    public void example1() {
        List<List<Integer>> nodes = UtUtils.stringToIntegerList2("[[0,-1],[1,0],[2,0],[3,2],[4,2]]");
        Assertions.assertTrue(solutionP2764.isPreorder(nodes));
    }

    @Test
    public void example2() {
        List<List<Integer>> nodes = UtUtils.stringToIntegerList2("[[0,-1],[1,0],[2,0],[3,1],[4,1]]");
        Assertions.assertFalse(solutionP2764.isPreorder(nodes));
    }
}