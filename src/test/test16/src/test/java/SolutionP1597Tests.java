import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1597Tests {
    private final SolutionP1597 solutionP1597 = new SolutionP1597();

    @Test
    public void example1() {
        String s = "3*4-2*5";
        SolutionP1597.Node expected = new SolutionP1597.Node('-');
        expected.left = new SolutionP1597.Node('*');
        expected.right = new SolutionP1597.Node('*');
        expected.left.left = new SolutionP1597.Node('3');
        expected.left.right = new SolutionP1597.Node('4');
        expected.right.left = new SolutionP1597.Node('2');
        expected.right.right = new SolutionP1597.Node('5');
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1597.expTree(s)));
    }
}
